import React, { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import AppContext from "../Context/Context";
import unplugged from "../assets/unplugged.png"

const Home = ({ selectedCategory }) => {
  const { data, isError, addToCart, refreshData } = useContext(AppContext);
  const [products, setProducts] = useState([]);
  const [isDataFetched, setIsDataFetched] = useState(false);

  useEffect(() => {
    if (!isDataFetched) {
      refreshData();
      setIsDataFetched(true);
    }
  }, [refreshData, isDataFetched]);

  useEffect(() => {
    if (data && data.length > 0) {
      const fetchImagesAndUpdateProducts = async () => {
        const updatedProducts = await Promise.all(
          data.map(async (product) => {
            try {
              const response = await axios.get(
                `http://localhost:8080/api/product/${product.id}/image`,
                { responseType: "blob" }
              );
              const imageUrl = URL.createObjectURL(response.data);
              return { ...product, imageUrl };
            } catch (error) {
              console.error(
                "Error fetching image for product ID:",
                product.id,
                error
              );
              return { ...product, imageUrl: "placeholder-image-url" };
            }
          })
        );
        setProducts(updatedProducts);
      };

      fetchImagesAndUpdateProducts();
    }
  }, [data]);

  const filteredProducts = selectedCategory
    ? products.filter((product) => product.category === selectedCategory)
    : products;

  if (isError) {
    return (
      <h2 className="text-center" style={{ padding: "18rem" }}>
      <img src={unplugged} alt="Error" style={{ width: '100px', height: '100px' }}/>
      </h2>
    );
  }
  return (
    <>
      <div
        className="grid"
        style={{
          marginTop: "64px",
          display: "grid",
          gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
          gap: "20px",
          padding: "20px",
        }}
      >
        {filteredProducts.length === 0 ? (
          <h2
            className="text-center"
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            No Products Available
          </h2>
        ) : (
          filteredProducts.map((product) => {
            const { id, brand, name, price, productAvailable, imageUrl } =
              product;
            const cardStyle = {
              width: "18rem",
              height: "12rem",
              boxShadow: "rgba(0, 0, 0, 0.24) 0px 2px 3px",
              backgroundColor: productAvailable ? "#fff" : "#ccc",
            };
            return (
              <div
                className="card mb-3"
                style={{
                  width: "250px",
                  height: "360px",
                  boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
                  borderRadius: "10px",
                  overflow: "hidden", 
                  backgroundColor: productAvailable ? "#fff" : "#ccc",
                  display: "flex",
                  flexDirection: "column",
                  justifyContent:'flex-start',
                  alignItems:'stretch'
                }}
                key={id}
              >
                <Link
                  to={`/product/${id}`}
                  style={{ textDecoration: "none", color: "inherit" }}
                >
                  <img
                    src={imageUrl}
                    alt={name}
                    style={{
                      width: "100%",
                      height: "150px", 
                      objectFit: "cover",  
                      padding: "5px",
                      margin: "0",
                      borderRadius: "10px 10px 10px 10px", 
                    }}
                  />
                  <div
                    className="card-body"
                    style={{
                      flexGrow: 1,
                      display: "flex",
                      flexDirection: "column",
                      justifyContent: "space-between",
                      padding: "10px",
                    }}
                  >
                    <div>
                      <h5
                        className="card-title"
                        style={{ margin: "0 0 10px 0", fontSize: "1.2rem" }}
                      >
                        {name.toUpperCase()}
                      </h5>
                      <i
                        className="card-brand"
                        style={{ fontStyle: "italic", fontSize: "0.8rem" }}
                      >
                        {"~ " + brand}
                      </i>
                    </div>
                    <hr className="hr-line" style={{ margin: "10px 0" }} />
                    <div className="home-cart-price">
                      <h5
                        className="card-text"
                        style={{ fontWeight: "600", fontSize: "1.1rem",marginBottom:'5px' }}
                      >
                        <i class="bi bi-currency-rupee"></i>
                        {price}
                      </h5>
                    </div>
                    <button
                      className="btn-hover color-9"
                      style={{margin:'10px 25px 0px '  }}
                      onClick={(e) => {
                        e.preventDefault();
                        addToCart(product);
                      }}
                      disabled={!productAvailable}
                    >
                      {productAvailable ? "Add to Cart" : "Out of Stock"}
                    </button> 
                  </div>
                </Link>
              </div>
            );
          })
        )}
      </div>
    </>
  );
};

export default Home;





db.books.aggregate([
  {
    $match: {
      BookCategory: "Classics"
    }
  },
  {
    $project: {
      _id: 0,
      BookTitle: 1,
      BookAuthor: 1,
      PriceList: {
        $switch: {
          branches: [
            {
              case: { $gt: ["$BookPrice", 10000] },
              then: "High Cost"
            },
            {
              case: {
                $and: [
                  { $gte: ["$BookPrice", 5000] },
                  { $lte: ["$BookPrice", 10000] }
                ]
              },
              then: "Medium Cost"
            },
            {
              case: { $lt: ["$BookPrice", 5000] },
              then: "Least Cost"
            }
          ],
          default: "Unknown"
        }
      }
    }
  }
]);

db.employees.find({
  Email: { $regex: "@gmail\\.com$", $options: "i" }
}).count();


db.books.aggregate([
  {
    $project: {
      _id: 0,
      BookTitle: 1,
      BookPrice: 1,
      ReducedPrice: {
        $subtract: [
          "$BookPrice",
          { $multiply: [ "$BookPrice", 0.10 ] }
        ]
      }
    }
  }
]);


db.employees.aggregate([
  {
    $match: {
      Job: "Operator",
      EdLevel: { $lt: 15 }
    }
  },
  {
    $project: {
      _id: 0,
      FirstName: 1,
      HireYear: 1,
      EdLevel: 1,
      UpdatedSalary: {
        $add: [
          "$Salary",
          { $multiply: ["$Salary", 0.20] }
        ]
      }
    }
  }
]).pretty();


db.books.aggregate([
  {
    $match: {
      BookPrice: { $gt: 2000 },
      BookPublisher: "James Patrick"
    }
  },
  {
    $project: {
      _id: 0,
      BookInfo: {
        $concat: [
          "$BookTitle",
          " is written by ",
          "$BookAuthor"
        ]
      },
      Published_Year: { $year: "$PublishDate" }
    }
  }
]);


db.employees.aggregate([
  {
    $match: {
      HireYear: 2000,
      DeptNo: { $not: { $in: [null, "", " "] } } // just ensure it exists (can be short)
    }
  },
  {
    $project: {
      _id: 0,
      FirstName: 1,
      Password: {
        $concat: [
          { $substr: ["$FirstName", 0, 3] },
          {
            $cond: {
              if: { $gte: [{ $strLenCP: "$DeptNo" }, 2] },
              then: { $substr: ["$DeptNo", 0, 2] },
              else: ""
            }
          }
        ]
      }
    }
  },
  {
    $sort: { FirstName: -1 }
  }
]);


db.employees.aggregate([
  {
    $match: {
      $and: [
        { $expr: { $eq: [{ $year: "$HireDate" }, 2000] } },
        { DeptNo: { $exists: true, $ne: null } },
      ],
    },
  },
  {
    $project: {
      FirstName: 1,
      Password: {
        $concat: [
          { $substr: ["$FirstName", 0, 3] },
          {
            $substr: [
              { $toString: "$DeptNo" },
              0,
              2,
            ],
          },
        ],
      },
    },
  },
  {
    $sort: {
      FirstName: -1,
    },
  },
  {
    $project: {
      _id: 0,
      FirstName: 1,
      Password: 1,
    },
  },
])


db.employees.aggregate([
  // First filter: Get employees hired in 2000 with any DeptNo
  {
    $match: {
      HireYear: 2000,
      DeptNo: { $exists: true, $nin: [null, "", " "] }
    }
  },
  // Add a field to check DeptNo length
  {
    $addFields: {
      deptValid: { $gte: [{ $strLenCP: "$DeptNo" }, 2] }
    }
  },
  // Project the final output
  {
    $project: {
      _id: 0,
      FirstName: 1,
      Password: {
        $concat: [
          { $substr: ["$FirstName", 0, 3] },
          {
            $cond: {
              if: "$deptValid",
              then: { $substr: ["$DeptNo", 0, 2] },
              else: ""
            }
          }
        ]
      }
    }
  },
  // Final sorting
  {
    $sort: { FirstName: -1 }
  }
])

db.employees.find({
  HireYear: 2000,
  FirstName: { $in: ["Sunil", "Senthil", "Jackson", "Harini", "Aravind"] }
}, { FirstName: 1, DeptNo: 1, HireYear: 1 })



db.employees.aggregate([
  {
    $match: {
      HireYear: 2000,
      $or: [
        { DeptNo: { $exists: true, $nin: [null, "", " "] } },
        { FirstName: "Harini" } // Explicitly include Harini regardless of DeptNo
      ]
    }
  },
  {
    $project: {
      _id: 0,
      FirstName: 1,
      Password: {
        $concat: [
          { $substr: ["$FirstName", 0, 3] },
          {
            $cond: {
              if: {
                $and: [
                  { $ne: ["$DeptNo", null] },
                  { $ne: ["$DeptNo", ""] },
                  { $ne: ["$DeptNo", " "] },
                  { $gte: [{ $strLenCP: "$DeptNo" }, 2] }
                ]
              },
              then: { $substr: ["$DeptNo", 0, 2] },
              else: ""
            }
          }
        ]
      }
    }
  },
  {
    $sort: { FirstName: -1 }
  }
])
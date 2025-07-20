package com.cipherwiz.SpringEcom.Repository;

import com.cipherwiz.SpringEcom.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}

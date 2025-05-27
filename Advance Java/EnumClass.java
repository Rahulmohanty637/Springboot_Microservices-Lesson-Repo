enum Laptop {
    HP(1000), IBM(2000), Macbook(3000);

    // If we create the object in same class then we use private constructor

    private int price;

    private Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

public class EnumClass {

    public static void main(String[] args) {
        // Laptop lap = Laptop.HP;
        // System.out.println(lap + " : " + lap.getPrice());

        for (Laptop lap : Laptop.values()) {
            System.out.println(lap + " : " + lap.getPrice());
        }
    }

}

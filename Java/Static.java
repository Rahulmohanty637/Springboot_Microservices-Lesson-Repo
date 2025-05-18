public class Static {
    public static void main(String[] args) {
        Mobile ob1 = new Mobile();
        Mobile ob2 = new Mobile();

        ob1.brand = "Apple";
        ob1.price = 289;

        ob2.brand = "Samsung";
        ob2.price = 123;

        Mobile.name = "SmartPhone";

        ob1.show();
        ob2.show();

        Mobile.show1(ob1);
    }

}

class Mobile {

    String brand;
    int price;
    static String name;

    public void show() {
        System.out.println(brand + " : " + price + " : " + name);
    }

    public static void show1(Mobile obj) {
        System.out.println("show1 " + obj.brand + " : " + obj.price);
    }
}

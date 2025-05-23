// Interface

interface A {
    // instance variables are final and static
    int age = 24;
    String location = "Bangalore";

    void show();

    void config();
}

class B implements A {

    @Override
    public void show() {
        System.out.println("In show");
    }

    @Override
    public void config() {
        System.out.println("In config");
    }

}

public class Interface {
    public static void main(String[] args) {
        B obj = new B();
        obj.config();
        obj.show();
        System.out.println(A.location);
    }
}

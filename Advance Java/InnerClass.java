
public class InnerClass {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        A.B obj1 = obj.new B(); // when the inner class is non static we need object of outer class to create an
                                // object of inner class
        obj1.config();

        // A.B obj1 = new A.B(); // If the class is static we can create object with the
        // help of outer class name

    }

}

class A {
    int age;

    public void show() {
        System.out.println("in show");
    }

    class B {
        public void config() {
            System.out.println("in config");
        }
    }
}

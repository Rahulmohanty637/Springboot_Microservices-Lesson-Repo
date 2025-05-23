// Abstract Anonymous Inner Class

abstract class A {
    public abstract void show();

    public abstract void config();
}

public class AbstractAIC {
    public static void main(String[] args) {
        A obj = new A() {

            public void show() {
                System.out.println("In show");
            }

            public void config() {
                System.out.println("In config");
            }

        };
    }
}

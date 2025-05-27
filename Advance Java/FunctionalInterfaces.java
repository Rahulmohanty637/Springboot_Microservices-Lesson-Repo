
@FunctionalInterface
interface A {
    void show(int i);
}

@FunctionalInterface
interface B {
    int add(int i, int j);
}

public class FunctionalInterfaces {
    public static void main(String[] args) {

        // we use Lambda Expressions to reduce the syntax of anonymous class
        // implementations
        A obj = i -> System.out.println("Hello World" + " " + i);
        obj.show(6);

        // Lambda Expression with return type
        B obj2 = (i, j) -> i + j;
        System.out.println("Result is: " + obj2.add(6, 6));
    }
}

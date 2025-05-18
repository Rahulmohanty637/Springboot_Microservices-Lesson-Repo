public class MethodOverloading {

    public static void main(String[] args) {

        Calculator cal = new Calculator();
        System.out.println(cal.add(4, 5));
    }

}

class Calculator {

    public int add(int a, int b) {
        return (a + b);
    }

    public int add(int a, int b, int c) {
        return (a + b + c);
    }

}
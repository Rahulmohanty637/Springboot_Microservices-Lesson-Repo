public class ClassAndObjects {

    public static void main(String[] args) {
        int a = 10;
        int b = 30;
        Calculator cal = new Calculator();
        int num = cal.add(a, b);
        System.out.println(num);

    }
}

class Calculator {

    int a;

    public int add(int num1, int num2) {
        int r = num1 + num2;
        return r;
    }
}

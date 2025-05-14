public class Conditional {
    public static void main(String[] args) {

        int a = 6;
        int b = 2;
        int c = 10;

        if (a < b) {
            System.out.println("Hello World");
        } else {
            System.out.println("Just Hello");
        }

        if (a > b && a > c) {
            System.out.println(a);
        } else if (b > a && b > c) {
            System.out.println(b);
        } else if (c > b && c > a) {
            System.out.println(c);
        }
    }

}

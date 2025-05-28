public class Exceptions {
    public static void main(String[] args) {
        int x = 2;
        int y = 0;
        try {
            y = 18 / x;
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }
        System.out.println("Value of y is " + y);

    }
}

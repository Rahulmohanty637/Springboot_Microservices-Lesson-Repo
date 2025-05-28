public class TryCatch {
    public static void main(String[] args) {
        int x = 2;
        int y = 0;
        int[] num = new int[5];
        String str = null;

        try {
            y = 18 / x;
            System.out.println(str.length());
            System.out.println(num[1]);
            System.out.println(num[5]);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Stay in your limit");
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
        System.out.println("Value of y is " + y);
    }
}

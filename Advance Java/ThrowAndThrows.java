class RahulException extends Exception {
    public RahulException(String str) {
        super(str);
    }
}

public class ThrowAndThrows {
    public static void main(String[] args) {
        int i = 20;
        int j = 0;

        try {
            j = 18 / i;
            if (j == 0) {
                throw new RahulException("Don't want to print zero");
            }
        } catch (RahulException e) {
            j = 18 / 1;
            System.out.println("Thats the default output " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }

        System.out.println(j);
        System.out.println("Bye");
    }
}

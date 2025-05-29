import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResources {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int num = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new java.io.InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        } finally {
            br.close();
        }

        // But whenever we have a class or the interface which is AutoCloseable by
        // default, then there won't be any need to explicitly write the closing
        // statement for such classes and interfaces.
        // So whenever we use try with resources, it will automatically close the
        // resource that is being used in this block of code.

        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(bfr.readLine());
            System.out.println(num);
        }
    }
}

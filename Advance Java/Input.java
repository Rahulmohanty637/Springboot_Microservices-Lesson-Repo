import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number: ");
        // int num = System.in.read();

        // BufferReader
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        int num = Integer.parseInt(bf.readLine());
        System.out.println(num);


        // Scanner
        System.out.println("Enter 2nd number: ");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        System.out.println(num1);
        
        
        bf.close();
        sc.close();
    }
}

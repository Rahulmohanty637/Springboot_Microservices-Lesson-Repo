public class Loops {
    public static void main(String[] args) {
        int i = 1;

        // While Loop
        while (i <= 5) {
            System.out.println("Hi " + i);
            int j = 1;
            while (j <= 3) {
                System.out.println("Hello");
                j++;
            }
            i++;
        }
        System.out.println("Bye " + i);

        // Do-While Loop
        int k = 1;
        do {
            System.out.println("Hello " + k);
            k++;
        } while (k < 0);

        // For Loop
        for (int a = 0; a < 5; a++) {
            System.out.println("DAY: " + (a + 1));

            for (int j = 1; j <= 9; j++) {
                System.out.println("Hour: " + (j + 8) + "--" + (j + 9));
            }
        }
    }
}

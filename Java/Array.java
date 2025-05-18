public class Array {
    public static void main(String[] args) {
        int nums[] = { 2, 6, 9, 3 };
        int nums1[] = new int[4];

        System.out.println(nums[2]);

        for (int i = 0; i < 4; i++) {
            nums1[i] = i + 26;
            System.out.println("The value at index " + i + " is: " + nums1[i]);
        }

        // Mulit Dimensional Array
        int arr[][] = new int[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("The value at index " + i + ", and sub-index of " + j + " is: " + arr[i][j]);
                // Math.random() gives random number of type double.
                arr[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Enhanced for loop
        for (int n[] : arr) {
            for (int m : n) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
}

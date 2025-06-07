import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Print {
    public static void main(String[] args) {
        // Custom input array
        int arr[] = { 4, 3, 2, 1 };

        // Outer loop
        for (int i = 0; i < arr.length; i++) {

            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arr.length; j++) {

                // Checking elements
                int temp = 0;
                if (arr[j] < arr[i]) {

                    // Swapping
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Printing sorted array elements
            System.out.print(arr[i] + " ");
        }

        // Custom input array
        int[] arr1 = { 13, 7, 6, 45, 21, 9, 101, 102 };

        // Calling the sort() method present
        // inside Arrays class
        Arrays.sort(arr1);

        // Printing and display sorted array
        System.out.printf("Modified arr[] : %s",
                Arrays.toString(arr));

        // Note that we have Integer here instead of
        // int[] as Collections.reverseOrder doesn't
        // work for primitive types.
        Integer[] arr2 = { 13, 7, 6, 45, 21, 9, 2, 100 };

        // Sorts arr[] in descending order
        // Arrays.sort(arr, Collections.reverseOrder());

        System.out.printf("Modified arr[] : %s",
                Arrays.toString(arr));

        // Create a list of strings
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

        /*
         * Collections.sort method is sorting the
         * elements of ArrayList in ascending order.
         */
        Collections.sort(al);

        // Let us print the sorted list
        System.out.println("List after the use of"
                + " Collection.sort() :\n" + al);
    }

}

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

        int sum = 0;
        for (Integer integer : nums) {
            if (integer % 2 == 0) {
                integer = integer * 2;
                sum += integer;
            }
        }

        System.out.println(sum);
        System.out.println(nums);

        // Apart from normal for loop and forEach loop there another way to iterate the
        // list, which using forEach method
        nums.forEach(n -> System.out.println(n * 2));

        // Now instead of using forEach method and writing all the logic we can use
        // Stream which have predefined methods that will help you to reduce the code.
        // The main objective of using stream is to not mutate the actual value from
        // list which performing any operation on them
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
        int result = s3.reduce(0, (c, e) -> c + e);
        System.out.println(result);

        // Optimized syntax
        int ans = nums.stream()
                    .filter(n -> n % 2 == 0)
                    .map(n -> n * 2)
                    .reduce(0, (c, e) -> c + e);
        System.out.println(ans);

    }
}

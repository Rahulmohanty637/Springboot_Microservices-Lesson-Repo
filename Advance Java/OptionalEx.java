import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Vikram", "Nikhitha", "Prajat");

        Optional<String> searchedName = names.stream().filter(name -> name.contains("x")).findFirst();
        String searchedName1 = names.stream().filter(name -> name.contains("s")).findFirst().orElse("Not found");

        System.out.println(searchedName.orElse("Not found with this character"));
        System.out.println(searchedName1);
    }
}

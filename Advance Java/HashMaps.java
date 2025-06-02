import java.util.Map;
import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();

        students.put("Rahul", 98);
        students.put("Manisha", 73);
        students.put("Srinibash", 86);
        students.put("Aman", 63);

        System.out.println("Students: " + students);

        // Printing the Hashmap using for each loop
        // students.keySet() gives set of keys
        for (String key : students.keySet()) {
            System.out.println(key + " : " + students.get(key));
        }

    }
}

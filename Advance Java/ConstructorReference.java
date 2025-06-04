import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Students {
    private int age;
    private String name;

    public Students(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students [age=" + age + ", name=" + name + "]";
    }

}

public class ConstructorReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Navin", "Virat", "Sachin");

        List<Students> students = new ArrayList<>();

        for (String name : names) {
            students.add(new Students(name));
        }

        students = names.stream().map(name -> new Students(name)).toList();
        
        students = names.stream().map(Students::new).toList();

        System.out.println(students);
    }

}

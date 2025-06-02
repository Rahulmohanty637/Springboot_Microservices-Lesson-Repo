import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Students implements Comparable<Students> {
    int age;
    String name;

    public Students(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students [age=" + age + ", name=" + name + "]";
    }

    // Implementing Comparable interface and compareTo method we can define the
    // logic of sorting in class itself. Without using Comparator in main method
    @Override
    public int compareTo(Students o) {
        // since we are defining this method in class so "this" refers to current object
        // and another object is passed for comparison.
        if (this.age > o.age) {
            return 1;
        } else {
            return -1;
        }
    }

}

public class Sorting {
    public static void main(String[] args) {

        // Comparator is a concept or a interface using which you can specify your own
        // logic for sorting
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                if (i % 10 > j % 10) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(89);

        Collections.sort(nums, com);

        // System.out.println(nums);

        Comparator<Students> comp = (i, j) -> i.age > j.age ? 1 : -1;

        List<Students> stu = new ArrayList<>();
        stu.add(new Students(23, "Sri"));
        stu.add(new Students(12, "Kumar"));
        stu.add(new Students(18, "Varun"));
        stu.add(new Students(25, "Rakesh"));
        stu.add(new Students(19, "Sidharth"));

        Collections.sort(stu, comp);
        Collections.sort(stu);

        for (Students students : stu) {
            System.out.println(students);
        }

    }
}

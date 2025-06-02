import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(17);
        set.add(65);
        set.add(89);
        set.add(37);
        set.add(17);
        set.add(92);
        set.add(83);

        System.out.println(set);

        Iterator<Integer> values = set.iterator();

        while (values.hasNext())
            System.out.println(values.next());

        // for (Integer integer : set) {
        // System.out.println(integer);
        // }

        // TreeSet gives sorted array in ascending order
        Collection<Integer> set1 = new TreeSet<Integer>();
        set1.add(17);
        set1.add(65);
        set1.add(89);
        set1.add(37);
        set1.add(17);
        set1.add(92);
        set1.add(83);

        System.out.println(set1);
    }
}

enum Status {
    Running, Failed, Pending, Success;
}

public class Enum {
    public static void main(String[] args) {
        Status s = Status.Failed;
        System.out.println(s);
        System.out.println(s.ordinal());

        Status[] ss = Status.values();
        for (int i = 0; i < ss.length; ++i) {
            System.out.println(ss[i] + " : " + ss[i].ordinal());
        }
    }
}

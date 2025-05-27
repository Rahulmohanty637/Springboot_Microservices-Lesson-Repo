enum Status {
    Running, Pending, Failed, Success;
}

public class EnumIfAndSwitch {
    public static void main(String[] args) {

        Status s = Status.Failed;
        System.out.println(s.getClass().getSuperclass());

        // If Else statement
        if (s == Status.Success) {
            System.out.println("Success");
        } else if (s == Status.Pending || s == Status.Running) {
            System.out.println("Pending or Running");
        } else {
            System.out.println("Try Again");
        }

        // Switch
        switch (s) {
            case Running:
                System.out.println("All Good");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Pending:
                System.out.println("Please Wait");
                break;
            default:
                System.out.println("Success");
                break;
        }

    }
}

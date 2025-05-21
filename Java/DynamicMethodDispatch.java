class Computers {
    public void show() {
        System.out.println("A");
    }
}

class Laptops extends Computers {
    public void show() {
        System.out.println("B");
    }
}

class Ipads extends Computers {
    public void show() {
        System.out.println("C");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Computers obj = new Computers();
        obj.show();

        obj = new Laptops();
        obj.show();

        obj = new Ipads();
        obj.show();
    }

}

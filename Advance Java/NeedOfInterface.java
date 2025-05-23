interface Computer {
    void work(Computer obj);
}

class Laptop implements Computer {
    public void work(Computer obj) {
        System.out.println("Code, Compile, Run...");
    }

}

class Desktop implements Computer {
    public void work(Computer obj) {
        System.out.println("Code, Compile, Run...: but faster");
    }
}

public class NeedOfInterface {
    public static void main(String[] args) {
        Computer obj = new Laptop();
        Computer emp = new Desktop();
        obj.work(obj);
        emp.work(emp);
    }
}

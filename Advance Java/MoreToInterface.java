// class - class -> extends
// class - interface -> implements
// interface - interface -> extends

interface X {
    int age = 44; // final and static
    String ares = "Bangalore";

    void show();

    void config();

}

interface Y {
    void run();
}

interface Z extends Y {

}

class A implements X, Z {

    @Override
    public void run() {
        System.out.println("Run");
    }

    @Override
    public void show() {
        System.out.println("Show");
    }

    @Override
    public void config() {
        System.out.println("Config");
    }

}

public class MoreToInterface {
    public static void main(String[] args) {
        X obj = new A();
        obj.show();
        obj.config();

        Y obj1 = new A();
        obj1.run();

        System.out.println("Main");
    }
}

public class ThisAndSuperMethod {
    public static void main(String[] args) {
        B obj = new B(6);
        System.out.println(obj);

    }
}

class A {
    public A() {
        System.out.println("in A");
    }

    public A(int n) {
        this();
        System.out.println("in A int");
    }
}

class B extends A {

    public B() {
        super(5);
        System.out.println("in B");
    }

    public B(int n) {
        this();
        System.out.println("in B int");
    }
}

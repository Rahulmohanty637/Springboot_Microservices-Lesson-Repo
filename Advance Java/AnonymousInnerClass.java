class A {
    public void show() {
        System.out.println("in A show");
    }
}

class B extends A {
    public void show() {
        System.out.println("in B show");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        A obj = new B() {
            public void show() {
                System.out.println("in Anonymous Inner Class");
            }
        };
        obj.show();
    }
}

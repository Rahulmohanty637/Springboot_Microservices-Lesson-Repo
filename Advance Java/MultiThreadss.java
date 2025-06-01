class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("HI");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadss {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        Runnable obj3 = new C();

        // obj2.setPriority(Thread.MAX_PRIORITY);
        // System.out.println(obj1.getPriority());
        // obj1.start();
        // obj2.start();

        // Thread t1 = new Thread(obj3);
        // t1.start();

        Runnable obj4 = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hello");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

         Thread t2 = new Thread(obj4);
        t2.start();

    }
}

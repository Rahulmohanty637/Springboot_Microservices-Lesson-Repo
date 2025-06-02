
class Counter {
    int count;
    public synchronized void add() {
        count++;
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable obj1 = () -> {
            for (int i = 1; i <= 1000; i++) {
                c.add();
            }
        };

        Runnable obj2 = () -> {
            for (int i = 1; i <= 1000; i++) {
                c.add();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        c.add();
        System.out.println(c.count);
    }
}

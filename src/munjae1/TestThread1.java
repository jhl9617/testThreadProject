package munjae1;

import static java.lang.Thread.interrupted;

public class TestThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Increment(50));
        Thread t2 = new Thread(new Decrement(12, 45));



        t1.start();
        t2.start();
        System.out.println(t1.isInterrupted());
    }
}

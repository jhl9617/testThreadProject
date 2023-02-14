package munjae1;

public class Decrement implements Runnable{
    private int a;
    private int b;

    public Decrement(int a, int b) {
        this.a = a;
        this.b = b;


    }


    @Override
    public void run() {
        for(int i = b; i > a; i--) {
            System.out.println("D : " +i + " ");
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

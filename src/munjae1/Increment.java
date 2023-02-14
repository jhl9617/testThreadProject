package munjae1;

public class Increment implements Runnable{
    private int a;
    public Increment(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        for(int i = 1; i < a+1; i += 2) {
            System.out.println("in : "+ i + " ");
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package test.thread;

public class Mythread2 implements Runnable{
    @Override
    public void run() {
        //1~500������ ���� ���� ���
        for(int i = 1 ; i < 1001; i++){
            System.out.print(i + " ");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

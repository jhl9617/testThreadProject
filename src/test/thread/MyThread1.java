package test.thread;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        //500�� �� ���� ���
        for(int i = 0 ; i< 1000; i++) {
            System.out.print("* ");
            try {
                Thread.sleep(100L); //1000�� 1����
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

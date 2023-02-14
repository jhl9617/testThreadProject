package test.thread;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        //500번 별 문자 출력
        for(int i = 0 ; i< 1000; i++) {
            System.out.print("* ");
            try {
                Thread.sleep(100L); //1000이 1초임
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package test.thread;

public class TestMyThread {
    public static void main(String[] args) {
        //MyThread 테스트
        //멀티스레드 프로그램 작동

        //Thread 상속받은 경우
//        Thread m1 = new MyThread1();
//        Thread t1 = m1;
        Thread t1 = new MyThread1();

        //Runnable 상속받은 경우
//        Mythread2 m2 = new Mythread2();
//        Runnable r = m2;
//        Thread t2 = new Thread(r);
        Thread t2 = new Thread(new Mythread2());

        //스레드의 설정된 우선순위 확인
        System.out.println("t1 : " +t1.getPriority());
        System.out.println("t2 : " +t2.getPriority());

        //스레드의 우선순위 설정
        t1.setPriority(Thread.MAX_PRIORITY);    //1
        t2.setPriority(Thread.MIN_PRIORITY);    //10
        //우선순위 반영

        System.out.println("t1 : " +t1.getPriority());
        System.out.println("t2 : " +t2.getPriority());


        //클래스의 오버라이딩 된 run() 실행함
        t1.start();
        t2.start();
    }
}

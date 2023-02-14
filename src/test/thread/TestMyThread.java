package test.thread;

public class TestMyThread {
    public static void main(String[] args) {
        //MyThread �׽�Ʈ
        //��Ƽ������ ���α׷� �۵�

        //Thread ��ӹ��� ���
//        Thread m1 = new MyThread1();
//        Thread t1 = m1;
        Thread t1 = new MyThread1();

        //Runnable ��ӹ��� ���
//        Mythread2 m2 = new Mythread2();
//        Runnable r = m2;
//        Thread t2 = new Thread(r);
        Thread t2 = new Thread(new Mythread2());

        //�������� ������ �켱���� Ȯ��
        System.out.println("t1 : " +t1.getPriority());
        System.out.println("t2 : " +t2.getPriority());

        //�������� �켱���� ����
        t1.setPriority(Thread.MAX_PRIORITY);    //1
        t2.setPriority(Thread.MIN_PRIORITY);    //10
        //�켱���� �ݿ�

        System.out.println("t1 : " +t1.getPriority());
        System.out.println("t2 : " +t2.getPriority());


        //Ŭ������ �������̵� �� run() ������
        t1.start();
        t2.start();
    }
}

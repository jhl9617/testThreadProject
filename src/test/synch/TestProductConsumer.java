package test.synch;

public class TestProductConsumer {
    public static void main(String[] args) {
        //�����ڿ� �������� ���� ������ ������ ���� �׽�Ʈ
        Buffer buffer = new Buffer();   //������ü

        new Thread(new Producer((buffer))).start();
        new Thread(new Consumer(buffer)).start();
    }


}

//���� �ڿ��� Ŭ����
class Buffer {
    private int data;
    private boolean empty = true;

    //������ data ���� ������ �޼ҵ�
    public synchronized int getData() {
        while (empty) { //������ data�� ����ִ� ����
            try {
                wait(); //������ ����Ŵ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   //empty�� false�� �Ǹ� ���� �����
        //��, ������ data�� ���� ���� �����
        empty = true;   //���� �������̹Ƿ�, �ٽ� ����ٰ� ó����
        notifyAll();    //wait �� ��������� ��� ������·� �ٲ�
        return data;    //���� �ѱ��(������) ����ִ� ���·� �ٲ�
    }

    //������ data �� ���� �ִ� �޼ҵ�
    public synchronized void putData(int data) {
        while (!empty) {    //���ۿ� ���� �ִ� ����
            try {
                wait();     //������ ����Ŵ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   //���� �������� �� ���°� �Ǹ� ������ ����

        this.data = data;   //������ data�� �� ����
        empty = false;      //��� ���� �ʴٰ� ǥ����
        notifyAll();
    }
}


//�����ڿ� Buffer �� ���� ������ �ִ� ������
class Producer implements Runnable {

    private Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 1 ; i < 11; i++) {
            buffer.putData(i);
            System.out.println("Producer : " + i + "�� ������ ���� �Ͽ����ϴ�.");
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

//�����ڿ� Buffer�� ���������� ������ ������
class Consumer implements Runnable {
    private Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 11; i++){
            int data = buffer.getData();
            System.out.println("Consumer : " +  data + "�� ������ �Ǹ� �Ͽ����ϴ�.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
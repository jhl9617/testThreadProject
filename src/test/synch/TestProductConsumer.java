package test.synch;

public class TestProductConsumer {
    public static void main(String[] args) {
        //공급자와 생성자의 동작 원리로 스레드 조정 테스트
        Buffer buffer = new Buffer();   //공유객체

        new Thread(new Producer((buffer))).start();
        new Thread(new Consumer(buffer)).start();
    }


}

//공유 자원용 클래스
class Buffer {
    private int data;
    private boolean empty = true;

    //버퍼의 data 값을 꺼내는 메소드
    public synchronized int getData() {
        while (empty) { //버퍼의 data가 비어있는 동안
            try {
                wait(); //스레드 대기시킴
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   //empty가 false가 되면 루프 종료됨
        //즉, 버퍼의 data에 값이 들어온 경우임
        empty = true;   //값을 꺼낸것이므로, 다시 비었다고 처리함
        notifyAll();    //wait 된 스레드들을 모두 실행상태로 바꿈
        return data;    //값을 넘기고(꺼내고) 비어있는 상태로 바꿈
    }

    //버퍼의 data 에 값을 넣는 메소드
    public synchronized void putData(int data) {
        while (!empty) {    //버퍼에 값이 있는 동안
            try {
                wait();     //스레드 대기시킴
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   //값이 꺼내져서 빈 상태가 되면 루프가 끝남

        this.data = data;   //버퍼의 data에 값 넣음
        empty = false;      //비어 있지 않다고 표시함
        notifyAll();
    }
}


//공유자원 Buffer 에 공유 데이터 넣는 스레드
class Producer implements Runnable {

    private Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 1 ; i < 11; i++) {
            buffer.putData(i);
            System.out.println("Producer : " + i + "번 케익을 생성 하였습니다.");
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

//공유자원 Buffer에 공유데이터 꺼내는 스레드
class Consumer implements Runnable {
    private Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 11; i++){
            int data = buffer.getData();
            System.out.println("Consumer : " +  data + "번 케익을 판매 하였습니다.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
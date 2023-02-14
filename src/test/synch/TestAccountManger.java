package test.synch;

public class TestAccountManger {
    public static void main(String[] args) {
        //여러 스레드 공유자원 사용시 동기화 처리 테스트
        Thread t1 = new AccountManger("인터넷 뱅킹");
        Thread t2 = new AccountManger("체크카드");
        Thread t3 = new AccountManger("뱅킹앱");

        t1.start();
        t2.start();
        t3.start();

    }
}

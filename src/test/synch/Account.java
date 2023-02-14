package test.synch;


//동기화처리 테스트용 통장 클래스
public class Account {
    private static int balance = 10000; //잔액 : 공유자원

    public Account() {}

    public static void setBalance(int balance) {
        Account.balance = balance;
    }

    public static int getBalance() {
        return balance;
    }


    //출금(인출)하는 메소드
    public /*synchronized*/ void withdraw(int money) throws BalanceNotEnoughException {
        //동작 확인을 위한 sleep() 사용

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //동기화 메소드 대신에 동기화 블럭을 사용할 수도 있음
        synchronized (this){
            if(balance >= money) {
                balance -= money;
                System.out.println(money + " 인출됨");
            } else {
                throw new BalanceNotEnoughException("잔액이 부족합니다.");
            }
        }

    }



}

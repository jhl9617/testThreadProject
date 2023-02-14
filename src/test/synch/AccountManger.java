package test.synch;

public class AccountManger extends Thread{
    private Account account;    //통장
    private String using;   //인출방식

    public AccountManger() {
        account = new Account();
    }

    public AccountManger(String using) {
        this();                 //첫줄에만 기입함, 자신의 기본생성자 실행시킴
        this.using = using;
    }

    @Override
    public void run() {
        if(account.getBalance() > 0) {
            System.out.println(using + " : 현재 잔액 -" + account.getBalance());
            //인출할 금액은 랜덤 값을 적용함
            int money = new java.util.Random().nextInt(10) * 1000;
            System.out.println(using + " : 인출금액 - " + money);

            try {
                account.withdraw(money);
            } catch (BalanceNotEnoughException e) {
                System.out.println(using + " : " + e.getMessage());
            }
        }
    }

}

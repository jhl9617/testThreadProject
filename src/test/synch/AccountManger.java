package test.synch;

public class AccountManger extends Thread{
    private Account account;    //����
    private String using;   //������

    public AccountManger() {
        account = new Account();
    }

    public AccountManger(String using) {
        this();                 //ù�ٿ��� ������, �ڽ��� �⺻������ �����Ŵ
        this.using = using;
    }

    @Override
    public void run() {
        if(account.getBalance() > 0) {
            System.out.println(using + " : ���� �ܾ� -" + account.getBalance());
            //������ �ݾ��� ���� ���� ������
            int money = new java.util.Random().nextInt(10) * 1000;
            System.out.println(using + " : ����ݾ� - " + money);

            try {
                account.withdraw(money);
            } catch (BalanceNotEnoughException e) {
                System.out.println(using + " : " + e.getMessage());
            }
        }
    }

}

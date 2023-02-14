package test.synch;


//����ȭó�� �׽�Ʈ�� ���� Ŭ����
public class Account {
    private static int balance = 10000; //�ܾ� : �����ڿ�

    public Account() {}

    public static void setBalance(int balance) {
        Account.balance = balance;
    }

    public static int getBalance() {
        return balance;
    }


    //���(����)�ϴ� �޼ҵ�
    public /*synchronized*/ void withdraw(int money) throws BalanceNotEnoughException {
        //���� Ȯ���� ���� sleep() ���

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //����ȭ �޼ҵ� ��ſ� ����ȭ ���� ����� ���� ����
        synchronized (this){
            if(balance >= money) {
                balance -= money;
                System.out.println(money + " �����");
            } else {
                throw new BalanceNotEnoughException("�ܾ��� �����մϴ�.");
            }
        }

    }



}

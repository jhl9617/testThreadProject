package test.synch;

public class TestAccountManger {
    public static void main(String[] args) {
        //���� ������ �����ڿ� ���� ����ȭ ó�� �׽�Ʈ
        Thread t1 = new AccountManger("���ͳ� ��ŷ");
        Thread t2 = new AccountManger("üũī��");
        Thread t3 = new AccountManger("��ŷ��");

        t1.start();
        t2.start();
        t3.start();

    }
}

package munjae2;

import javax.swing.*;
import java.awt.*;

public class TestDrawing extends JFrame {
    //Field
    private DrawRect rect;
    private DrawCircle circle;

    //������
    public TestDrawing() {
        //����� ������ ������ â(������) ����� ���̰� �ϱ�
        super("��Ƽ������ �ǽ�2"); //â ���� ���� ����
        //â ũ��� ��ġ ����
        this.setBounds(new Rectangle(100, 100,500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //X ������ ���α׷� ����

        this.setVisible(true);  //â ���̰� ��
    }

    //repaint() �޼ҵ忡 ���ؼ� ���� ������ paint() �޼ҵ� �������̵�
    //paint() �޼ҵ� �ȿ� �����ӿ� �׷��� ������ �ۼ���

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(rect.getX(), rect.getY(), 10, 10);
        g.setColor(Color.RED);
        g.fillOval(circle.getX(), circle.getY(), 10, 10);

    }

    public static void main(String[] args) {
        //��Ƽ������ �ǽ�����2
        TestDrawing test2 = new TestDrawing();

        test2.rect = new DrawRect(test2, 100);
        test2.circle = new DrawCircle(test2, 100);

        Thread t1 = test2.rect;
        Thread t2 = test2.circle;

        t1.start();
        t2.start();




    }
}

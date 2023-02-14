package munjae2;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

//�����ӿ� �Ķ��� �簢���� �׸��� ������
public class DrawRect extends Thread{
    private int rectNumber; //�׸� �簢�� ����
    private Random r;
    private int x;      //�簢�� ��ġ x��ǥ
    private int y;      //�簢�� ��ġ y��ǥ
    private JFrame frame;


    public DrawRect(JFrame frame, int rectNumber) {
        this.frame = frame;
        this.rectNumber = rectNumber;
        r = new Random();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        //�簢�� �׸� ������(������ â) ������ ��ġ�� ũ�� ��ȸ
        Rectangle framSize = frame.getBounds();

        for(int i = 0; i < this.rectNumber; i++) {
            //�簢�� �׷��� ��ġ ���� (������ ���� ��)
            this.x = r.nextInt(framSize.width);
            this.y = r.nextInt(framSize.height);

            //������ ���ΰ�ħ��
            // repaint() ���� : ���� paint() �����
            frame.repaint();    //�簢���� �׷���
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }

}

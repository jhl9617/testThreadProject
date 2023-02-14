package munjae2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawCircle extends Thread{
    private int circleNumber; //�׸� �� ����
    private Random r;
    private int x;      //�� ��ġ x��ǥ
    private int y;      //�� ��ġ y��ǥ
    private JFrame frame;


    public DrawCircle(JFrame frame, int circleNumber) {
        this.frame = frame;
        this.circleNumber = circleNumber;
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
        //�� �׸� ������(������ â) ������ ��ġ�� ũ�� ��ȸ
        Rectangle framSize = frame.getBounds();

        for(int i = 0; i < this.circleNumber; i++) {
            //�� �׷��� ��ġ ���� (������ ���� ��)
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

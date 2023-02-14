package munjae3;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class CarGame extends JFrame {

    private JLabel label1, label2, label3;

    //������
    public CarGame() {
        this.setTitle("Car Raceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        this.setSize(700, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //�� ��ü ����
        label1 = new JLabel();
        label1.setIcon(new ImageIcon("images/car1.gif"));
        label2 = new JLabel();
        label2.setIcon(new ImageIcon("images/car2.gif"));
        label3 = new JLabel();
        label3.setIcon(new ImageIcon("images/car3.gif"));

        //�����ӿ� �������� �߰���
        add(label1);
        add(label2);
        add(label3);

        //��ġ�� ũ������
        label1.setBounds(10,10, 50, 50);
        label2.setBounds(10,60, 50, 50);
        label3.setBounds(10,110, 50, 50);

        //�� ������ ������ �̹��� ������ ����
        new CarRace().start();

        this.setVisible(true);
    }
    //���� Ŭ���� : ����� ����� (private, static ����� �� ����)

    private class CarRace extends Thread {

        private int x1 = 10, x2 = 10, x3 = 10;

        @Override
        public void run() {
            for(int i = 0; i < 121; i++){
                //������ �� ���� x��ǥ�� 120�� �߻���Ŵ
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                x1 += (int)(Math.random() * 10);    //0 ~ 9
                label1.setBounds(x1, 10, 50, 50);
                x2 += (int)(Math.random() * 10);    //0 ~ 9
                label2.setBounds(x2, 60, 50, 50);
                x3 += (int)(Math.random() * 10);    //0 ~ 9
                label3.setBounds(x3, 110, 50, 50);

            }
        }

    }


    public static void main(String[] args) {
        new CarGame();

    }
}

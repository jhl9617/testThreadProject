package munjae2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawCircle extends Thread{
    private int circleNumber; //그릴 원 갯수
    private Random r;
    private int x;      //원 위치 x좌표
    private int y;      //원 위치 y좌표
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
        //원 그릴 프레임(윈도우 창) 영역의 위치와 크기 조회
        Rectangle framSize = frame.getBounds();

        for(int i = 0; i < this.circleNumber; i++) {
            //원 그려질 위치 지정 (프레임 영역 안)
            this.x = r.nextInt(framSize.width);
            this.y = r.nextInt(framSize.height);

            //프레임 새로고침함
            // repaint() 실행 : 실제 paint() 실행됨
            frame.repaint();    //사각형이 그려짐
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

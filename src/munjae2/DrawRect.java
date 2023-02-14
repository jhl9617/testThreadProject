package munjae2;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

//프레임에 파란색 사각형을 그리는 스레드
public class DrawRect extends Thread{
    private int rectNumber; //그릴 사각형 갯수
    private Random r;
    private int x;      //사각형 위치 x좌표
    private int y;      //사각형 위치 y좌표
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
        //사각형 그릴 프레임(윈도우 창) 영역의 위치와 크기 조회
        Rectangle framSize = frame.getBounds();

        for(int i = 0; i < this.rectNumber; i++) {
            //사각형 그려질 위치 지정 (프레임 영역 안)
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

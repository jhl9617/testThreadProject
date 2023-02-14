package munjae2;

import javax.swing.*;
import java.awt.*;

public class TestDrawing extends JFrame {
    //Field
    private DrawRect rect;
    private DrawCircle circle;

    //생성자
    public TestDrawing() {
        //실행시 보여질 윈도우 창(프레임) 만들어 보이게 하기
        super("멀티스레드 실습2"); //창 제목 글자 지정
        //창 크기와 위치 지정
        this.setBounds(new Rectangle(100, 100,500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //X 누르면 프로그램 종료

        this.setVisible(true);  //창 보이게 함
    }

    //repaint() 메소드에 의해서 실제 구동될 paint() 메소드 오버라이딩
    //paint() 메소드 안에 프레임에 그려질 내용을 작성함

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(rect.getX(), rect.getY(), 10, 10);
        g.setColor(Color.RED);
        g.fillOval(circle.getX(), circle.getY(), 10, 10);

    }

    public static void main(String[] args) {
        //멀티스레드 실습문제2
        TestDrawing test2 = new TestDrawing();

        test2.rect = new DrawRect(test2, 100);
        test2.circle = new DrawCircle(test2, 100);

        Thread t1 = test2.rect;
        Thread t2 = test2.circle;

        t1.start();
        t2.start();




    }
}

import javax.swing.*;
import java.awt.*;

class MyPanel02 extends JPanel{
    public void paintComponent(Graphics g){
        //여기다가 그림그리기.
        //1. Color 정하기.
        //2. drawRect (라인그릴때 ) fillRect(색을 채울떄)  Rect  사각형
        g.setColor(new Color(210, 179, 87));
        g.fillRect(100,270,20,200);
        g.setColor(new Color(95, 210, 87));
        g.fillRect(140,370,20,100);
        g.setColor(new Color(116, 131, 213));
        g.fillRect(180,150,20,320);

        //글자 그리기 글자를 그림으로 그린것. 1. Color 정하기 2. Font정하기 3.g.drawString("그릴 내용",x,y)
        g.setColor(new Color(210, 137, 232));
        g.setFont(new Font("맑은 고딕",Font.BOLD,30)); //
        g.drawString("Java",200,100);

        //라인그리기 1. Color 정하기
        g.setColor(new Color(232, 137, 173));
        g.drawLine(150,150,300,300);

        //동그라미 그리기
        g.setColor(new Color(61, 56, 57));
        g.fillOval(300,300,100,100);
        g.drawOval(350,350,150,150);

        //모서리가 둥근 사각형 만들기
        g.setColor(new Color(181, 252, 138));
        g.drawRoundRect(300,20,100,100,30,30);


        g.setColor(new Color(255, 221, 214));
        g.drawArc(300,200,100,100,0,180); // x,y,넓이,높이,시작각,끝나는각 설정

        g.fillArc(300,100,100,100,0,330);

        int x [] = {100,50,100,150};
        int y[] = {100,150,200,150};
        g.drawPolygon(x,y,4); // 폐곡선
    }
}
public class Graphics01 extends JFrame {
    private MyPanel02 graphicsPanel = new MyPanel02();
    public Graphics01() throws HeadlessException {
        this.setTitle("Graphics");
        this.setSize(500,500);

//        Container c = this.getContentPane();
        this.setContentPane(graphicsPanel);





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Graphics01();
    }
}

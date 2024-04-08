import javax.swing.*;
import java.awt.*;
class MyPanel extends  JPanel{
    //JPanel , JButton, JLabel등등에 그림을 그릴수 있다.
    private Color colors[] = {Color.red,Color.blue,Color.yellow,Color.green};
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);  //테두리 컬러
//        g.fillRect();// 채우는 그리기
//        g.drawRect(); // 테두리 그리기
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                g.fillRect(55*j+5,35*i+5,50,30); //라인그리기
                g.setColor(colors[i%4]);
            }
        }
        //게임을 자바로 만들지않는다.
        g.setColor(Color.black);
        g.fillOval(200,200,20,20);
        g.drawString("게임오버",50,200);
    }
}

public class Paint01 extends JFrame {
    private MyPanel myPanel = new MyPanel();  //컨테이너

    public Paint01() throws HeadlessException {
        this.setTitle("그림그리기");
        this.setSize(300,300);
        Container c = this.getContentPane();
        this.setContentPane(myPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Paint01();
    }
}

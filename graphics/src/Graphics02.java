import javax.swing.*;
import java.awt.*;

class MyPanel03 extends JPanel{
    private ImageIcon imageIcon = new ImageIcon("images/1.png");
    private Image image = imageIcon.getImage();

    public void paintComponent(Graphics g){
       //여기다가 그림그리기
        super.paintComponent(g);
        // g.drawImage(image,0,0,this)
//        g.setClip(100,100,100,100); //마스크 clipping path라고도함. 자른부위만 보겠다 라는뜻
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this); // 화면의 크기에맞춰 이미지의 크기조절
    }
}
public class Graphics02 extends JFrame {
    private MyPanel03 graphicsPanel = new MyPanel03();
    public Graphics02() throws HeadlessException {
        this.setTitle("Graphics");
        this.setSize(500,500);

//        Container c = this.getContentPane();
        this.setContentPane(graphicsPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Graphics02();
    }
}

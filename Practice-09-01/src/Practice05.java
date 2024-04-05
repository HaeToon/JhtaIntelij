import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice05 extends JFrame {
    int num=10;
    public Practice05() throws HeadlessException {
        this.setTitle("Training01 JLable");
        this.setSize(400,400);
        Container c = this.getContentPane();
        JLabel label = new JLabel("label");
        c.setLayout(new FlowLayout());  //Container Default Layout  = BorderLayout
        c.add(label);
        label.setOpaque(true);
        label.setBackground(Color.yellow);
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode()==107){//num을 참조하려면 바깥class에 num을 선언하거나 변경하지않는다면 final을붙인다.
                    num+=5;  // 자바에서는 익명클래스 안에서 지역변수에 참조할수없다. int num에 final 붙이면 참조는 가능하나 변경이 불가능하다.
                    label.setFont(new Font("Arial",Font.PLAIN,num));
                }else if (e.getKeyCode()==109){
                    num-=5;
                    label.setFont(new Font("Arial",Font.PLAIN,num));
                }
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new Practice05();
    }
}

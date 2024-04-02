import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;

public class NullLayoutTest extends JFrame {
    public NullLayoutTest() {
        this.setTitle("Null layout");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this. getContentPane();
        container.setLayout(null); // null은 자유롭게 배치 대신 위치랑 크기는 세팅해야한다.
        JLabel label01 = new JLabel("나는 레이블");
        JLabel label02 = new JLabel("나는 레이블02");
        label01.setSize(100,30);
        label02.setSize(100,30);
        label02.setLocation(0,30);
//        container.add(label01);
//        container.add(label02);
        for(int i=0; i<9; i++){
            JButton jButton = new JButton(Integer.toString(i+1));
            jButton.setSize(50,50);
            jButton.setLocation(50*(i%3),50*(i/3)); // 0,0 50,100,0 0,50,
            container.add(jButton);
        }
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new NullLayoutTest();
    }
}

import javax.swing.*;
import java.awt.*;

public class Practice01 extends JFrame {
    public Practice01() {
        this.setTitle("Let's study Java");
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Practice01 practice01 =new Practice01();
    }
}

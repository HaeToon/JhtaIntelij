import javax.swing.*;
import java.awt.*;

public class Practice01 extends JFrame {
    public Practice01() { // (String title)
        this.setTitle("Let's study Java"); // super(title);
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Practice01 practice01 = new Practice01(); //("Let's study Java")
    }
}

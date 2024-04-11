import javax.swing.*;
import java.awt.*;

class ShakeLabel0503 extends JLabel {

    private int dir=0;
    private int gap = 2;
    public ShakeLabel0503(String str) {
        this.setText("타이머");
        this.setSize(500,500);
        this.setLocation(100,50);
        this.setFont(new Font("맑은 고딕",Font.BOLD,42));
    }

}

public class Practice0503 extends JFrame {
    public Practice0503() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(500,500);
        this.setLocation(100,50);
        Container c = this.getContentPane();
        c.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ShakeLabel0503 shakeLabel0503 = new ShakeLabel0503("덜덜덜덜");
        c.add(shakeLabel0503);
    }

    public static void main(String[] args) {
        new Practice0503();
    }
}

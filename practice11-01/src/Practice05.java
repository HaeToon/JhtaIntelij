import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class ImagePanel04 extends JPanel {
    public ImagePanel04() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int gapX = this.getWidth()/10;
        int gapY = this.getHeight()/10;
        for (int i = 0; i < 12; i++) {
            g.drawLine(gapX * (i + 1), 0, gapX * (i + 1), this.getWidth());
        }
        for (int i = 0; i < 12; i++) {
            g.drawLine(0, gapY * (i + 1), this.getHeight(), gapY * (i + 1));
        }
    }

}
public class Practice05 extends JFrame {
    public Practice05() throws HeadlessException {
        this.setTitle("Moving Circle");
        this.setSize(500,500);

        ImagePanel04 imagePanel = new ImagePanel04();
        this.setContentPane(imagePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice05();
    }
}

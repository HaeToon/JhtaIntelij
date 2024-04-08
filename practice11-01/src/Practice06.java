import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class ImagePanel05 extends JPanel {
    public ImagePanel05() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int gap=10;

        for (int i = 0; i < 50; i++) {
            int x[] = {300,0+gap,300,600-gap};
            int y[] = {0+gap,300,600-gap,300};
            g.drawPolygon(x,y,4);
            gap+=5;
        }

    }

}
public class Practice06 extends JFrame {
    public Practice06() throws HeadlessException {
        this.setTitle("Moving Circle");
        this.setSize(500,500);

        ImagePanel05 imagePanel = new ImagePanel05();
        this.setContentPane(imagePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice06();
    }
}

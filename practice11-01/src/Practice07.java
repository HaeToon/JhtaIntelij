import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ImagePanel06 extends JPanel {
    private List<Integer>mouseX = new ArrayList<>();
    private List<Integer>mouseY = new ArrayList<>();
    public ImagePanel06() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
//                System.out.println("click");
                mouseX.add(e.getX());
                mouseY.add(e.getY());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        int total = mouseX.size();
        int x[] = new int[total];
        int y[] = new int[total];
        for (int i=0; i<total; i++){
            x[i]=mouseX.get(i);
            y[i]=mouseY.get(i);
        }
        super.paintComponent(g);
        g.drawPolygon(x, y,total);

    }
}

public class Practice07 extends JFrame {
    public Practice07() throws HeadlessException {
        this.setTitle("Moving Circle");
        this.setSize(800, 800);

        ImagePanel06 imagePanel = new ImagePanel06();
        this.setContentPane(imagePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice07();
    }
}

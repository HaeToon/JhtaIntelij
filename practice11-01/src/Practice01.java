import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImgPanel extends JPanel{
    ImageIcon imageIcon = new ImageIcon("C:\\Users\\jhta\\Desktop\\ham.jpg");
    Image image = imageIcon.getImage();
    private JButton btn = new JButton("hide/show");
    private boolean isDraw = false;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isDraw==true) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }

    }

    public ImgPanel() {
        this.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("토글버튼입니다");
                isDraw=!isDraw; // isDraw를 누를때마다 반댓값(!isDraw)으로 초기화
                repaint();
            }
        });
    }
}
public class Practice01 extends JFrame {
    ImgPanel imgPanel = new ImgPanel();
    public Practice01() throws HeadlessException {
        this.setTitle("Hide/Show");
        this.setSize(500,500);

        this.setContentPane(imgPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
}

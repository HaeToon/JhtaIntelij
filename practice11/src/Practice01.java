import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class HideShowImagePanel extends JPanel {
    private ImageIcon imageIcon = new ImageIcon("image/ham.jpg");
    private Image image = imageIcon.getImage();


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
class North extends JPanel{
    public North() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton hideNShow = new JButton("hide");
        this.add(hideNShow);
        hideNShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton hideNShow = (JButton)e.getSource();
                String btn = hideNShow.getText();
                if(btn.equals("hide")){
                    hideShowImagePanel.setVisible(false);
                    hideNShow.setText("show");
                }else if (btn.equals("show")){
                    hideNShow.setText("hide");
                    hideShowImagePanel.setVisible(true);
                }
            }
        });

    }
}

public class Practice01 extends JFrame {
    private HideShowImagePanel hideShowImagePanel = new HideShowImagePanel();

    public Practice01() throws HeadlessException {
        this.setTitle("Hide/Show");
        this.setSize(500, 500);
        Container c = this.getContentPane();
        JButton hideNShow = new JButton("hide");
        c.add(hideShowImagePanel);
        c.add(hideNShow,BorderLayout.NORTH);

//        c.add(new North(),BorderLayout.NORTH);

        hideNShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

//        this.setContentPane(hideShowImagePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Practice01();
    }
}

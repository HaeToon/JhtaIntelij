package practice06;

import practice03.Practice0302;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Practice0602 extends JFrame {
    public Practice0602() throws HeadlessException {
        this.setTitle("Click random");
        this.setSize(500,500);
        Container c = this.getContentPane();
        c.setLayout(null);
        JLabel label = new JLabel("C");
        label.setLocation(100,100);
        label.setSize(50,50);
        c.add(label);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        class InnerClass implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }
    }

    public static void main(String[] args) {
        new Practice0602();
    }
}

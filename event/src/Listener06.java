import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listener06 extends JFrame {
    private JLabel label  =new JLabel();
    int num = 10;
    public Listener06() {
        this.setTitle("Mouse Event 알아보기");
        this.setSize(400, 400);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(label);

        c.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
                if(e.getWheelRotation()<0){
                    num+=5;
                }else {
                    num-=5;
                }

                label.setFont(new Font("Arial",Font.PLAIN,num));
            }
        });
        MyMouseListener myMouseListener = new MyMouseListener();
//        MyMouseMotionListener myMouseMotionListener = new MyMouseMotionListener();
        c.addMouseListener(myMouseListener);
        c.addMouseMotionListener(myMouseListener);
        label.setText("마우스 이벤트 종류들 알아보기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        Listener06 listener06 = new Listener06();
    }
    class MyMouseListener implements MouseListener,MouseMotionListener { // implements를 하면 메서드를 전부 구현해야함

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x =e.getX();
            int y =e.getY();
            label.setText("Mouse Pressed ("+x+","+y+")");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int x =e.getX();
            int y =e.getY();
            label.setText("Mouse Released ("+x+","+y+")");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("마우스가 진입했을때(올라갔을때)");
            Container c = (Container)e.getSource(); // 이벤트를 받는 주체인 Container를 가리킴.
            c.setBackground(Color.gray);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("마우스가 내려갔을때");
            Container c = (Container)e.getSource(); // 이벤트를 받는 주체인 Container를 가리킴.
            c.setBackground(Color.lightGray);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x =e.getX();
            int y =e.getY();
            label.setText("Mouse Dragged ("+x+","+y+")");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int x =e.getX();
            int y =e.getY();
            label.setText("Mouse Moved ("+x+","+y+")");
        }
    }
}
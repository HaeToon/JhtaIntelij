import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//class MyKeyListener extends  KeyAdapter{
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            super.keyPressed(e);
//        }
//}
public class Listener05 extends JFrame {
    private JLabel label = null;
    private JLabel labels[] = new JLabel[3];
    public Listener05() {
//        JLabel label01 = new JLabel("");
//        JLabel label02 = new JLabel("");
//        JLabel label03 = new JLabel("");
        labels[0]=new JLabel("aaa");
        labels[1]=new JLabel("bbb");
        labels[2]=new JLabel("ccc");


        this.setTitle("Event Listener 처리5번");
        this.setSize(400, 400);
        Container c = this.getContentPane();
        c.setLayout(null);
        //Key Event를 받으려면 Focus가 있어야한다.
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                labels[0].setText(Integer.toString(e.getKeyCode()));
                labels[1].setText(Character.toString(e.getKeyChar()));
                System.out.println(e.getKeyCode());
                System.out.println(e.getKeyChar());
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    labels[0].setLocation(labels[0].getX()-10,200);
                    c.setBackground(Color.ORANGE);
                }else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    labels[0].setLocation(labels[0].getX()+10,200);
                   c.setBackground(Color.green);
                }else if (e.getKeyCode()==KeyEvent.VK_UP){
                    labels[0].setLocation(labels[0].getX(),labels[0].getY()-10);
                    c.setBackground(Color.green);
                }else if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    labels[0].setLocation(labels[0].getX(),labels[0].getY()+10);
                    c.setBackground(Color.green);
                }
            }
        });
        for(int i=0; i<3; i++){
            c.add(labels[i]);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.orange);
            labels[i].setSize(80,30);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }
    public static void main(String[] args) {
        new Listener05();
    }
}

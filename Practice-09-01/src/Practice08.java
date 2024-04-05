import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

public class Practice08 extends JFrame {
    Random r = new Random(); // (int)(Math.random());
    int num = 0;
    boolean isPlay = true;
    JLabel labels[] = new JLabel[3];
    JLabel label = new JLabel("시작합니다.");
    public Practice08() throws HeadlessException {
        this.setTitle("Casino");
        this.setSize(500,300);
        Container c = this.getContentPane();
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());
        label.setLocation(210,200);
        label.setSize(200,100);
        c.add(label);
        int pos = 20;
        for(int i=0; i<labels.length;i++){
            labels[i]= new JLabel("0");
            labels[i].setSize(100,100);
            labels[i].setLocation(pos,80);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.magenta);
            labels[i].setHorizontalAlignment(JLabel.CENTER); // 글자 가운데 정렬
            pos+=170;
            c.add(labels[i]);
        }
        //4개의 label 필요

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }
class MyKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_R){
            isPlay=true;
            labels[0].setText("0");
            labels[1].setText("0");
            labels[2].setText("0");
            label.setText("게임을 시작합니다.");
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && isPlay) {
            System.out.println("키가 눌러졌습니다.");
              int num01 = r.nextInt(5);
              int num02 = r.nextInt(5);
              int num03 = r.nextInt(5);
              labels[0].setText(Integer.toString(num01));
              labels[1].setText(Integer.toString(num02));
              labels[2].setText(Integer.toString(num03));
              num++;
                if(num01==num02&&num02==num03){
                    label.setText("축하합니다." + num + "번만에 맞았네욧");
                    isPlay=false;
                    num=0;
                }else {
                    label.setText("아쉽네욧");
                }


        }
    }
}
    public static void main(String[] args) {
        new Practice08();
    }
}

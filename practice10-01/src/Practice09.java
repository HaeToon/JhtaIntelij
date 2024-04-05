import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice09 extends JFrame {
    private JLabel labels[] = new JLabel[10];
    private JLabel resultLabel = new JLabel();
    JButton reset = new JButton("리셋");
    long start = 0;
    long end =0;
    private int num =0;
   public void makeGame(){
        for(int i=0; i<10;i++){
            int x = (int)(Math.random()*350)+50;
            int y = (int)(Math.random()*350)+50;
            labels[i].setLocation(x,y);
            labels[i].setVisible(true);
        }
    }
    public Practice09() throws HeadlessException {
        this.setTitle("Practice09");
        this.setSize(500, 500);

        reset.setSize(80,50);
        reset.setLocation(200,200);
        reset.setVisible(false);
        Container c = this.getContentPane();
        c.setLayout(null);
        resultLabel.setSize(100,30);
        resultLabel.setLocation(200,0);
        resultLabel.setBackground(Color.white);
        resultLabel.setOpaque(true);
        resultLabel.setVisible(false);
        c.add(resultLabel);
        c.add(reset);

        for(int i=0; i<10;i++){
            int x = (int)(Math.random()*400)+50;
            int y = (int)(Math.random()*400)+50;
            labels[i]=new JLabel(Integer.toString(i));
            labels[i].setFont(new Font("맑은 고딕",Font.BOLD,20));
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.orange);
            labels[i].setSize(30,30);
            labels[i].setLocation(x,y);
            labels[i].setHorizontalTextPosition(JLabel.CENTER);
            c.add(labels[i]);
            labels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   JLabel label = (JLabel) e.getSource();
//                    label.setVisible(false);
                    if(Integer.parseInt(label.getText())==0){
                        //1070~지금까지 흐른 milliSecond를알려줌
                        start = System.currentTimeMillis();
                    }
                   if(Integer.parseInt(label.getText())==num){
                       label.setVisible(false);
                       num++;
                       if(num==10){
                           end= System.currentTimeMillis();
                           long result = end-start;
                           long sec = result/1000;
                           long rest = result%1000;
                           resultLabel.setVisible(true);
                           resultLabel.setText(sec+"."+rest);
                           reset.setVisible(true);
                       }
                   }
                }
            });
        }
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeGame();
                reset.setVisible(false);
                resultLabel.setText("0");
                resultLabel.setVisible(false);
                num=0;
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice09();
    }
}

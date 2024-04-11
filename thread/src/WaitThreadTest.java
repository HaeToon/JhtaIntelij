import com.sun.source.tree.LabeledStatementTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameThread extends Thread {
    //thread 잠그기 wait
    private JLabel labels[];
    private JLabel resultLabel;

    public GameThread(JLabel[] labels,JLabel resultLabel) {
        this.labels = labels;
        this.resultLabel=resultLabel;
    }
   synchronized public void startGame(){
        this.notify();
    }
    synchronized void waitGame(){
    try {
        this.wait();//thread를 대기시킴.wait //notify(); thread대기해제
    } catch (InterruptedException e) {
       return;
    }

}

    @Override
    public void run() {
        while (true) {
            waitGame();
            try {
                int random01 = (int) (Math.random() * 3 + 1);
                int random02 = (int) (Math.random() * 3 + 1);
                int random03 = (int) (Math.random() * 3 + 1);
                //text바꾸기위해 접근하려면 생성자로 만든다.
                labels[0].setForeground(Color.black);
                labels[1].setForeground(Color.black);
                labels[2].setForeground(Color.black);

                Thread.sleep(300);
                labels[0].setForeground(Color.red);
                Thread.sleep(300);
                labels[0].setText(Integer.toString(random01));
                labels[0].setForeground(Color.blue);

                labels[1].setForeground(Color.red);
                Thread.sleep(300);
                labels[1].setForeground(Color.blue);
                labels[1].setText(Integer.toString(random02));

                labels[2].setForeground(Color.red);
                Thread.sleep(300);
                labels[2].setForeground(Color.blue);
                labels[2].setText(Integer.toString(random03));
                if(random01==random02 && random02==random03){
                    System.out.println("축하드립니다.!");
                }else {
                    System.out.println("아깝당");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class GamePanel extends JPanel {
    private JLabel labels[] = new JLabel[3];
    private JLabel resultLabel = new JLabel("마우스 클릭하면 게임이 시작됩니다.");


    GameThread gameThread = new GameThread(labels,resultLabel);

    public GamePanel() {
        this.setLayout(null);
        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel("0");
            labels[i].setSize(100, 50);
            labels[i].setLocation(100 * i + 150, 50);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setOpaque(true);
            labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 36));
            labels[i].setBackground(Color.pink);
            this.add(labels[i]);
        }
        this.add(resultLabel);
        resultLabel.setSize(50, 50);
        resultLabel.setSize(300, 50);
        resultLabel.setLocation(150, 200);
        gameThread.start();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("마우스 클릭");
                //순서대로 나와야함
                //Thread를 대기시키기
//                gameThread.notify(); //접근이 불가하므로 메서드로 변형시켜서 호출
                gameThread.startGame();

            }
        });
    }
}

public class WaitThreadTest extends JFrame {
    public WaitThreadTest() throws HeadlessException {
        this.setTitle("Snow");
        this.setSize(650, 370);

        Container c = this.getContentPane();
        this.setContentPane(new GamePanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WaitThreadTest();
    }
}

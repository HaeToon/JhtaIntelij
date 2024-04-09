import javax.swing.*;
import java.awt.*;

public class Quiz01 extends Thread{ //thread를 상속받아 override로 run을 구현한다.
    int i=0;
    @Override
    public void run() {
        //여기에 실행코드를 넣어주면 된다.
        //JLabel에다가 1초마다1씩증가하는 타이머 만들기.
        while(true){
            System.out.println(i);
            i++;
            try {
                sleep(1000);

            } catch (InterruptedException e) {  //run을 종료시킬때 InterruptedException try catch 해줭야함.
                throw new RuntimeException(e);
            }
        }
    }
    static class Quiz01a extends JFrame{
        public Quiz01a() throws HeadlessException {
            this.setTitle("타이머");
            this.setSize(200,200);

            Container c = this.getContentPane();
            JLabel jLabel = new JLabel(Integer.toString(1));
            c.add(jLabel,BorderLayout.CENTER);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Quiz01 thread01 = new Quiz01();
        Quiz01a quiz01a = new Quiz01a();
        thread01.run();
    }
}

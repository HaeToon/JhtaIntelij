import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener02 extends JFrame {
    public Listener02() {
        this.setTitle("Event Listener 처리2번");
        this.setSize(400, 400);
        JButton btn = new JButton("Click"); // MyActionListener클래스에서 JButton 활성화시 text인 Click을 리턴함.
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.add(btn);
//        ActionListener myActionListenr = new MyActionListener();
        btn.addActionListener(new MyActionListener02());
//        btn.addActionListener(myActionListener());
        //두번째 방법은 Class안에 Class를 만들어서 처리 [내부클래스] 같은 클래스 내에서만 호출가능
        //내부클래스는 private로 만들어서 내부에서만 사용할때 사용함.

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private class MyActionListener02 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) { //클래스의 내부에 만든것(내부클래스)은 클래스에 접근가능.
            System.out.println("나는 내부클래스로 만들어진 리스너입니다.");
            Listener02.this.setTitle("나는 내부 클래스에서 바꾼 타이틀 입니다.");//클래스에 접근한것.
        }
    }

    public static void main(String[] args) {
        new Listener02();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Listener01 extends JFrame {
    public Listener01() {
        this.setTitle("Event Listener 처리1번");
        this.setSize(400,400);
        JButton btn = new JButton("Click"); // MyActionListener클래스에서 JButton 활성화시 text인 Click을 리턴함.
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.add(btn);
//        ActionListener myActionListenr = new MyActionListener();
        btn.addActionListener(new MyActionListener());
//        btn.addActionListener(myActionListener());
        //첫번째 방법은 Class 따로 만들어서 처리 [외부클래스] 다른곳에서도 호출가능 listener 01 은 1번방법
        //자주사용하는 방법은 1번 3번.
        //두번째 방법은 Class안에 Class를 만들어서 처리 [내부클래스] 같은 클래스 내에서만 호출가능
        //세번째 방법은 익명클래스를 만들어서 바로 처리
        // 사용자(user)가 Event를 발생시켰을때 어떻게 반응해야하는지...

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Listener01();
    }
}

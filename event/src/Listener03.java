import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener03 extends JFrame {
    public Listener03() {
        this.setTitle("Event Listener 처리2번");
        this.setSize(400, 400);
        JButton btn = new JButton("Click"); // MyActionListener클래스에서 JButton 활성화시 text인 Click을 리턴함.
        JButton btn02 = new JButton("Click");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.add(btn);
        c.add(btn02);
        //익명클래스 생성과 동시에 사용할수있음.
        //하나하나 다 따로 만들어야함. 내외부에서 호출불가능
        //버튼이 딱 한가지일만 해야할때 만듬. 자주사용함.
        //구현해야할 메서드가 하나밖에없는 인터페이스는 람다식으로 변경할수있음.
        //상속 받은 인터페이스의 구현해야할 메서드가 하나일경우 람다식으로 변경가능.
        btn02.addActionListener(e->{ // 매개변수가 한개일경우 (e)의 소괄호도 생략가능. , 한줄일경우 {} 중괄호도 생략가능.
            System.out.println("click");
        });
//        btn.addActio
//        ActionListener myActionListenr = new MyActionListener();
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
            }
        });
//        btn.addActionListener(myActionListener());
        //세번째 방법은 익명클래스를 만들어서 바로 처리
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Listener03();
    }
}

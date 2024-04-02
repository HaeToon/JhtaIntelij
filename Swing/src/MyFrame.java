import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("title들어가는곳.");
        this.setSize(300,300);
        Container container = this.getContentPane(); // 제일바깥의 것 ContentPane 는 Container를 리턴함.
        JButton jButton01 = new JButton("클릭01");  //컴퍼넌트중하나
        JButton jButton02 = new JButton("클릭02");
        JButton jButton03 = new JButton("클릭03");
        JButton jButton04 = new JButton("클릭04");
        JButton jButton05 = new JButton("클릭05");


        //컴퍼넌트를 앉힐때 쓰는 layout이 있음 default = BorderLayout
        container.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
        container.add(jButton01,FlowLayout.RIGHT);
        //BorderLayout = 동서남북 FlowLayout 옆으로 배치

//        container.setLayout(new BorderLayout(10,10));
//        container.add(jButton01, BorderLayout.NORTH);
//        container.add(jButton02, BorderLayout.SOUTH);
//        container.add(jButton03, BorderLayout.EAST);
//        container.add(jButton04, BorderLayout.WEST);
//        container.add(jButton05, BorderLayout.CENTER);
        this.setVisible(true); // 보이는지 안보이는지 true로해야 보임
        //JPanel 에 다른 컴퍼넌트들을 가져다 넣는다.
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}

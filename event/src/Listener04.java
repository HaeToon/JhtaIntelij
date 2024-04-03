import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
class MyMouseAdapter extends MouseAdapter{
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse adpater 재정의");
    }
}
public class Listener04 extends JFrame {
    private JLabel label = null;
    public Listener04() {
        this.setTitle("Event Listener 처리2번");
        this.setSize(400, 400);
        Container c = this.getContentPane();
        c.setLayout(null);
        label = new JLabel("hello");
        label.setSize(30,30);
        c.add(label);
        //Adapter는 추상메서드로 인터페이스의 모든 메서드들이 구현되어있어 그중 하나를 골라서 재정의하여 사용할수있다.
        //Adapter는 2개이상의 메서드가 있는것에만 존재한다.
        //Key , Mouse,MouseMotion,Focus등등 ActionListener는 메서드가 하나라서 adapter가없다.
        //MouseAdapter는 추상클래스이므로 직접 생성해서 쓰지못한다.
        //Interface도 마찬가지로 추상클래스이므로 직접 생성해서 사용하지못한다.
        //익명클래스는 MouseAdapter를 상속받은 익명 자식클래스를 재정의하는 것이다.
//        c.addMouseListener(new MyMouseAdapter());
        c.addMouseListener(new MouseAdapter() { // MouseAdapter는 interface의 하나를 집어서 사용가능하다.
            //adapter는 익명함수로 사용 가능하지만 직접생성해서 사용할수없다.
            @Override
            public void mousePressed(MouseEvent e) {
                label.setLocation(e.getX(),e.getY());
            }
        });
        /*
        c.addMouseListener(new MouseListener() { //MouseListener는 interface이므로 메서드를 사용하지않아도 만들어야함.

            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("press");
                label.setLocation(e.getX(),e.getY());
            }


            @Override
            public void mouseReleased(MouseEvent e) {
//                System.out.println("release");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
*/

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
//    private class MyMouseListenr{
//
//    }

    public static void main(String[] args) {
        new Listener04();
    }
}

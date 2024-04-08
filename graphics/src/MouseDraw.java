import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

class MouseDrawPanel extends JPanel {
    private List<Point> startPoints = new ArrayList<>();
    private List<Point> endPoints = new ArrayList<>();
    Point oldPoint = null;

    public MouseDrawPanel() {
        //2개의 이벤트 필요 mousePressed mouseReleased
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_DELETE){
                    startPoints.clear();
                    endPoints.clear();
                    repaint();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
//                    startPoints.remove(startPoints.get(startPoints.size()-1));
//                    endPoints.remove(endPoints.get(endPoints.size()-1));
                    startPoints.removeLast();
                    endPoints.removeLast();
                    repaint();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    startPoints.removeFirst();
                    endPoints.removeFirst();
                    repaint();
                }
                super.keyTyped(e);
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                startPoints.add(oldPoint);  // 마우스를 눌렀을때 old포인트를 시작지점으로잡고 그뒤 드래그할때 이동하는부분을 startPoint로다시 잡는ㄷ.
                endPoints.add(e.getPoint()); //end point 에는 drag 중인 포인트를 집어넢음
                oldPoint=e.getPoint();
                repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //누르기
//                startPoints.add(e.getPoint());
                oldPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //떼기
//                endPoints.add(e.getPoint());
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g) { // paintComponent는 실행될때 한번만 그림. repaint() 필요
        super.paintComponent(g);
        //여기다가 그림그리기.
        //ArrayList 에 좌표가 들어가있음.
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        g.setColor(new Color(red,green,blue));
        for(int i=0; i<startPoints.size(); i++){
            int x1 = (int)this.startPoints.get(i).getX();
            int y1 = (int)this.startPoints.get(i).getY();
            int x2 = (int)this.endPoints.get(i).getX();
            int y2 = (int)this.endPoints.get(i).getY();
        g.drawLine(x1,y1,x2,y2);
        g.fillOval(x2-5,y2-5,10,10); // 천천히 그리면 ㄱㅊ

        }
    }

}

public class MouseDraw extends JFrame {
    private MouseDrawPanel graphicsPanel = new MouseDrawPanel();

    public MouseDraw() throws HeadlessException {
        this.setTitle("Graphics");
        this.setSize(800, 800);

//        Container c = this.getContentPane();
        this.setContentPane(graphicsPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new MouseDraw();
    }
}

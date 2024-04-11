import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class SnowFlake{
private int loadX;
private int loadY;
private int radius;
private int speedY;
//데이터 은닉 캡슐화
    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public SnowFlake(int loadX, int loadY, int radius , int speedY) {
        this.loadX = loadX;
        this.loadY = loadY;
        this.radius = radius;
        this.speedY =speedY;
    }

    public void setLoadX(int loadX) {
        this.loadX = loadX;
    }

    public void setLoadY(int loadY) {
        this.loadY = loadY;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getLoadX() {
        return loadX;
    }

    public int getLoadY() {
        return loadY;
    }

    public int getRadius() {
        return radius;
    }
}
class SnowPanel07 extends JPanel implements Runnable {
    private List<SnowFlake> snowList = new ArrayList<>();
    private ImageIcon bgIcon = new ImageIcon("image/back.jpg");
    private Image bg = bgIcon.getImage();

    public SnowPanel07() {
        makeSnow();
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (true) {
            //여기다가 눈내리는 코드
            for(int i=0; i<snowList.size(); i++){
                SnowFlake snowFlake = snowList.get(i);
//                int speedY=(int)(Math.random()*3+1); // 규칙적인 값
                snowFlake.setLoadY(snowFlake.getLoadY()+snowFlake.getSpeedY());

                if(snowFlake.getLoadY()>400){
                    int radius = (int)(Math.random()*10+5);
                    snowFlake.setLoadY(-5);
                    snowFlake.setLoadX((int)(Math.random()*640));
                  snowFlake.setRadius(radius);
                  snowFlake.setSpeedY(radius/2);
                }
            }
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void makeSnow() {
        for (int i = 0; i < 100; i++) {
            int loadX = (int) (Math.random() * 640);
            int loadY = (int) (Math.random() * 370);
            int radius = (int) (Math.random() * 10 + 10);
            int speedY = radius/2;
            SnowFlake snowFlake = new SnowFlake(loadX, loadY,radius,speedY);
            snowList.add(snowFlake);

        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        //배경그리기
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //fixel을 부드럽게 만들기 경계를 블러처리

        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
        g.setColor(Color.white);
        for (int i = 0; i < snowList.size(); i++) {
            SnowFlake snowFlake = snowList.get(i);
            g.fillOval(snowFlake.getLoadX(), snowFlake.getLoadY(), snowFlake.getRadius(), snowFlake.getRadius());
        }
    }
}

public class Practice07 extends JFrame {
    public Practice07() throws HeadlessException {
        this.setTitle("Snow");
        this.setSize(650, 370);

        this.setContentPane(new SnowPanel07());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice07();
    }
}

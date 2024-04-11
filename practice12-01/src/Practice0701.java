import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
class SnowFlake0701{
    private int loadX;
    private int loadY;
    private int radius;
    private int speedY;
    //데이터 은닉 캡슐화
    private double theta = 0;
    private int ratio = (int)(Math.random()*70);
    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public SnowFlake0701(int loadX, int loadY, int radius , int speedY) {
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
class SnowPanel0701 extends JPanel implements Runnable {
    private List<SnowFlake0701> snowList = new ArrayList<>();
    private ImageIcon bgIcon = new ImageIcon("image/back.jpg");
    private Image bg = bgIcon.getImage();
    private ImageIcon snowIcon = new ImageIcon("image/snowflake.png");
    private Image snow = snowIcon.getImage();
    public SnowPanel0701() {
        makeSnow();
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (true) {
            //여기다가 눈내리는 코드
            for(int i=0; i<snowList.size(); i++){
                SnowFlake0701 snowFlake0701 = snowList.get(i);
                snowFlake0701.setLoadY(snowFlake0701.getLoadY()+snowFlake0701.getSpeedY());

                if(snowFlake0701.getLoadY()>400){
                    int radius = (int)(Math.random()*10+5);
                    snowFlake0701.setLoadY(-5);
                    snowFlake0701.setLoadX((int)(Math.random()*640));
                    snowFlake0701.setRadius(radius);
                    snowFlake0701.setSpeedY(radius/2);
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
            SnowFlake0701 snowFlake0701 = new SnowFlake0701(loadX, loadY,radius,speedY);
            snowList.add(snowFlake0701);

        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        //배경그리기
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);

        for (int i = 0; i < snowList.size(); i++) {
            SnowFlake0701 snowFlake0701 = snowList.get(i);
            g.drawImage(snow,snowFlake0701.getLoadX(),snowFlake0701.getLoadY(),this);
        }
    }
}

public class Practice0701 extends JFrame {
    public Practice0701() throws HeadlessException {
        this.setTitle("Snow");
        this.setSize(650, 370);

        this.setContentPane(new SnowPanel0701());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice0701();
    }
}

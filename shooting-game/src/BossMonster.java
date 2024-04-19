import javax.swing.*;
import java.awt.*;

public class BossMonster {
   private int tx= 500;
   private int ty= 300;

    private int x, y, speedX,speedY, width, height, life;
    private ImageIcon imageIcon = new ImageIcon();

    public BossMonster() {

    }

    public BossMonster(ImageIcon imageIcon, int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
        this.life = life;
    }

    public BossMonster(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        life=100;
    }

    public void draw(Graphics g) {
        g.drawImage(imageIcon.getImage(), x, y, null);
        g.setColor(Color.green);
        g.fillRect(x,y-20,1*life+20,4);
    }
    public void move(){
        if(Math.random()<0.01){
            tx=(int)(Math.random()*(GamePanel.GAME_WITDH-imageIcon.getIconWidth()));
            ty=(int)(Math.random()*(GamePanel.GAME_HEIGHT-imageIcon.getIconHeight()));
        }
        x+=(tx-x)*0.05;  //도착지점과 현재지점을 5%씩쪼개서 이동함.
        y+=(ty-y)*0.05;


    }
    public int getWidth() {
        return imageIcon.getIconWidth();
    }

    public int getHeight() {
        return imageIcon.getIconHeight();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    int hit() {
        return life--;
    }


}

import javax.swing.*;
import java.awt.*;

public class BossBullet {
    private int x,y,speedX,speedY,width,height,angle,speed;
private ImageIcon imageIcon = new ImageIcon();
    public BossBullet() {

    }

    public BossBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BossBullet(ImageIcon imageIcon, int x, int y) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
    }

    public BossBullet(int x, int y, int speedX, int speedY, ImageIcon imageIcon) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.imageIcon = imageIcon;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getWidth() {
        return imageIcon.getIconWidth();
    }

    public int getHeight() {
        return imageIcon.getIconHeight();
    }
    public void move(int speed,int angle){
//        y+=speedY;
//        x+=speedX;
        x+=Math.sin(Math.toRadians(angle))*speed;
        y+=Math.cos(Math.toRadians(angle))*speed;
    }
    public void draw(Graphics g){
    g.drawImage(imageIcon.getImage(),x,y,null);
}
    @Override
    public String toString() {
        return "BossBullet{" +
                "x=" + x +
                ", y=" + y +
                ", speedX=" + speedX +
                ", speedY=" + speedY +
                ", imageIcon=" + imageIcon +
                '}';
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

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


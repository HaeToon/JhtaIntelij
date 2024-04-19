import javax.swing.*;
import java.awt.*;

public class Player {
//imageicon x,y,speedx,speedy
    private ImageIcon imageIcon = new ImageIcon();
    private int x,y,speedX,speedY,width,height;
    //new 할때 실행되는함수 (생성자함수)

    public int getWidth() {
        return imageIcon.getIconWidth();
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return imageIcon.getIconHeight();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Player() {

    }

    public Player(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public Player(ImageIcon imageIcon, int x, int y) {
        this.imageIcon = imageIcon;
        this.x = x;
        this.y = y;
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
    public void draw(Graphics g){
        g.drawImage(imageIcon.getImage(),x,y,null);
    }
    public void moveX(int speedX){
        x+=speedX;
    }
    public void moveY(int speedY){
        y+=speedY;
    }

    @Override
    public String toString() {
        return "Player{" +
                "imageIcon=" + imageIcon +
                ", x=" + x +
                ", y=" + y +
                ", speedX=" + speedX +
                ", speedY=" + speedY +
                '}';
    }
}

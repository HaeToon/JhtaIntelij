import javax.swing.*;
import java.awt.*;

public class Monster {
    private int x , y ,width,height,speedX,speedY;
    private ImageIcon imageIcon;

    public Monster(ImageIcon imageIcon,int x, int y) {
        this.imageIcon = imageIcon;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g) {
        g.drawImage(imageIcon.getImage(), x,y,null);
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

    public int getWidth() {
        return imageIcon.getIconWidth();
    }

    public int getHeight() {
        return imageIcon.getIconHeight();
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
    public void moveX(int speedX){
        x+=speedX;
    }
    public void moveY(int speedY){
        y+=speedY;
    }
    public boolean isRightTouched(){
        if(x+width>=GamePanel.GAME_WIDTH) {
            return true;
        }
        return false;
//        return x+radius>=GamePanel.GAME_WIDTH;
    }
    public boolean isLeftTouched(){
        if(x<=0) {
            return true;
        }
        return false;
//        return x+radius<=0;
    }
}
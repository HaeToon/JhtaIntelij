import javax.swing.*;
import java.awt.*;

public class GiftBox {
    private ImageIcon imageIcon;
    private int x,y,speedY,width,height;

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

    public GiftBox(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GiftBox(ImageIcon imageIcon,int x, int y) {
        this.x = x;
        this.y = y;
        this.imageIcon=imageIcon;
    }
public void draw(Graphics g){
        g.drawImage(imageIcon.getImage(),x,y,null);
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

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}

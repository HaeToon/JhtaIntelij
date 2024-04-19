import javax.swing.*;
import java.awt.*;

public class Boom {
    private int x,y,width,height;
    private ImageIcon imageIcon = new ImageIcon();
    public Boom() {

    }
    public Boom(ImageIcon imageIcon, int x, int y ) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
    }
    public void draw(Graphics g){
        g.drawImage(imageIcon.getImage(),x,y,null);
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


    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}

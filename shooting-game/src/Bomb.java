import javax.swing.*;
import java.awt.*;

public class Bomb {
    private int x, y;
    private ImageIcon imageIcon;
    private Image image;

    public Bomb(ImageIcon imageIcon,int x, int y ) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
        this.image = imageIcon.getImage();
    }
    public void draw(Graphics g){
        g.drawImage(imageIcon.getImage(),x,y,null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return imageIcon.getImage();
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

}

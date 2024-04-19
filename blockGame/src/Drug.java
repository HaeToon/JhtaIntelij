import javax.swing.*;
import java.awt.*;

public class Drug {
    private int x,y;
    private ImageIcon imageIcon;
    private Image image;
    public Drug(int x, int y, ImageIcon imageIcon) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
        this.image = imageIcon.getImage();
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
        return 16;
    }
    public int getHeight() {
        return 16;
    }

}

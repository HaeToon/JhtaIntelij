import javax.swing.*;
import java.awt.*;

public class Item {
    private int x, y;
    private ImageIcon imageIcon;
    private Image image;

    public Item(ImageIcon imageIcon,int x, int y ) {
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
        return 16;
    }

    public int getHeight() {
        return 16;
    }


}

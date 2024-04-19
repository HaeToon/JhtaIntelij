import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x,y,speedY,width,height,life;
    private ImageIcon imageIcon = new ImageIcon();
    public Enemy() {

    }
    public Enemy(ImageIcon imageIcon,int x, int y,int life ) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
        this.life=life;
    }
    public void draw(Graphics g){
        g.drawImage(imageIcon.getImage(),x,y,null);
        g.setColor(Color.green);
        g.fillRect(x,y-20,21*life,4);
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    int hit(){
       return life--;
    }
}

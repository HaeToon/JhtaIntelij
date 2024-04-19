import javax.swing.*;
import java.awt.*;

public class GameOver {
    ImageIcon gameOverImageIcon = new ImageIcon("images/game-over.png");
    Image gameOverImage = gameOverImageIcon.getImage();
    public static int GAME_WITDH = 1280;
    public static int GAME_HEIGHT = 720;
    public GameOver() {

    }
    void draw(Graphics g){
        g.drawImage(gameOverImage,GAME_WITDH/2-gameOverImage.getWidth(null)/2,GAME_HEIGHT/2-gameOverImage.getHeight(null)/2,null);
    }
}

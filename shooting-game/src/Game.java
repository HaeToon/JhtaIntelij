import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() throws HeadlessException {
        this.setTitle("Shooting Game");

        GamePanel gamePanel = new GamePanel();
        this.setContentPane(gamePanel);



        this.pack(); // 패널 사이즈에 맞추기 setLocationRelativeTo(null)보다 위에 위치해야함.
        this.setLocationRelativeTo(null); //화면 중앙 에 띄우기
        this.setResizable(false); //화면 크기변경 불가
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("images/earth.png"); //
        this.setIconImage(imageIcon.getImage());  //JFrame의 Icon 변경
    }

    public static void main(String[] args) {
        new Game();
    }
}

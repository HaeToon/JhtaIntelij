import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private GamePanel gamePanel;
    public Game() throws HeadlessException {
        this.setTitle("몬스터 피하기");
        this.setResizable(false); //화면 크기변경 불가
        gamePanel= new GamePanel();
        this.setContentPane(gamePanel);
        this.pack(); // 패널 사이즈에 맞추기
        this.setLocationRelativeTo(null); //화면 중앙 에 띄우기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}

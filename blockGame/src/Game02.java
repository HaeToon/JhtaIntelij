import javax.swing.*;
import java.awt.*;

public class Game02 extends JFrame {
    private GamePanel02 gamePanel02;
    public Game02() throws HeadlessException {
        this.setTitle("블럭게임");
        this.setResizable(false); //화면 크기변경 불가
        gamePanel02= new GamePanel02();
        this.setContentPane(gamePanel02);
        this.pack(); // 패널 사이즈에 맞추기
        this.setLocationRelativeTo(null); //화면 중앙 에 띄우기




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Game02();
    }
}

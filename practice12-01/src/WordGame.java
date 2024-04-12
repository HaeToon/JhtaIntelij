import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GamePanel extends JPanel implements Runnable { //위쪽 단어나오는부분
    private Words words = new Words("C:\\Users\\jhta\\Desktop\\Study\\wordList.txt");
    private JLabel wordLabel = new JLabel();
    private JLabel resultLabel = new JLabel();
    private String word = null; // getter를 쓰거나private를 public으로만들거나 GamePanel에서 구현해야함.
    Thread thread = new Thread(this);

    public boolean isSame(String inputWord){
        if(word.equals(inputWord)){
            return true;
        }
        return false;
    }
    public void startGame(){ //글자 다시 뽑기, 위치바꾸기,내려오게하기
        Thread thread = new Thread(this);
        word= words.getRandomWord(); //글자 다시뽑기
        wordLabel.setText(word);
        wordLabel.setSize(200,40);
        wordLabel.setLocation(0,-5);
        thread.start();
    }
    public void stopGame(){ //thread를 멈춘다.
        thread.interrupt(); // thread종료
    }
    public GamePanel() {
        word = words.getRandomWord();
        resultLabel.setText("결과");
        this.setLayout(null);
        this.add(wordLabel);
        wordLabel.setText(word);
        wordLabel.setLocation(0, -5);
        wordLabel.setForeground(Color.black);
        wordLabel.setSize(200, 50);
        wordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        resultLabel.setLocation(50,200);
        resultLabel.setSize(300,100);
        resultLabel.setFont(new Font("맑은고딕",Font.BOLD,40));
        resultLabel.setForeground(Color.white);
        this.add(resultLabel);
        this.setBackground(Color.pink);
        System.out.println(word);
        thread.start();
    }
    public void setResultLabel(String text){
        resultLabel.setText("결과 : "+text);
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(wordLabel.getY());
            wordLabel.setLocation(200, wordLabel.getY() + 1);
            this.repaint();
            if(wordLabel.getY()>540){
                resultLabel.setText("시간초과!!");
                wordLabel.setText("");
                stopGame();
                startGame();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("종료합니다.");
                return;
            }
        }
    }
}

class InputPanel extends JPanel { //아래쪽 입력부분
    GamePanel gamePanel; //gamePanel을 직접생성시 word가 두개씩 생김 매개변수로받아서 해야 값 비교가능.
    private JTextField input = new JTextField(15);

    public InputPanel(GamePanel gamePanel) { //gamePanel 을 매개변수로 받은 부분
        this.gamePanel=gamePanel;
        this.setBackground(Color.lightGray);
        this.add(input);
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = input.getText();
                if (text.equals("exit")) {
                    System.exit(0);
                }
                if(gamePanel.isSame(text)){
                    System.out.println("맞음");
                    gamePanel.stopGame();
                    gamePanel.startGame();
                    gamePanel.setResultLabel("딩동댕");
                }else {
                    System.out.println("틀림");
                    gamePanel.setResultLabel("땡");
                }
                    System.out.println(text);
                input.setText("");
            }
        });

    }
}

class Words {
    private List<String> wordList = new ArrayList<>();

    public Words(String fileName) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\Study\\wordList.txt");
            Scanner sc = new Scanner(fileReader);

            while (sc.hasNext()) {
                String word = sc.nextLine();
                wordList.add(word);
            }
            sc.close(); // 닫아야 가비지컬렉터가 수거해감.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomWord() {              //wordList에서 단어 하나 뽑기.
        int total = wordList.size();            //wordList의 개수
        int idx = (int) (Math.random() * total);    //wordList중 랜덤하나
        return wordList.get(idx);
    }
}

public class WordGame extends JFrame {
    private GamePanel gamePanel = new GamePanel(); //랜덤 단어 생성
    private InputPanel inputPanel = new InputPanel(gamePanel); //InputPanel(gamePanel)과 inputPanel을 같게만들어 값 비교가능.

    //    private Words words = new Words("C:\\Users\\jhta\\Desktop\\Study\\wordList.txt");
    public WordGame() throws HeadlessException {
        this.setTitle("워드게임");
        this.setSize(400, 600);

        Container c = this.getContentPane();

//        System.out.println(words.getRandomWord()); 확인용

        c.add(gamePanel, BorderLayout.CENTER);
        c.add(inputPanel, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WordGame();
    }
}

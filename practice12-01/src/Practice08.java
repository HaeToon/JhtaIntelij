import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class WordPanel extends JPanel implements Runnable{
   private List<String> wordList = new ArrayList<>();
   Scanner sc = null;
    public WordPanel() {
        File file = new File("C:\\Users\\jhta\\Desktop\\Study\\wordList.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            sc = new Scanner(fileInputStream);
            while(sc.hasNext()){
                wordList.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.close();
        int random = (int)(Math.random()*wordList.size());
        JLabel label = new JLabel(wordList.get(random));
        label.setFont(new Font("맑은 고딕",Font.BOLD,28));
        this.add(label);
    }

    @Override
    public void run() {

    }
}
class SouthPanel extends JPanel{
    public SouthPanel() {
        JTextField textField = new JTextField(20);
        this.add(textField);
        this.setBackground(Color.lightGray);
        this.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                System.out.println("입력됨 ==="+textField.getText());
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
        this.setFocusable(true);
        this.requestFocus();
    }
}
public class Practice08 extends JFrame {
    public Practice08() throws HeadlessException {
        this.setTitle("Word Game");
        this.setSize(400,600);

        SouthPanel southPanel = new SouthPanel();
        WordPanel wordPanel = new WordPanel();

        Container c = this.getContentPane();
        c.add(southPanel,BorderLayout.SOUTH);
        c.add(wordPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice08();
    }
}

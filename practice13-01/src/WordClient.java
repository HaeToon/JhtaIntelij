import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class WordClient extends JFrame {
    private JLabel search = new JLabel("찾을단어 >>>");
    private JTextField word = new JTextField(10);
    private JLabel result = new JLabel("result");
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public WordClient() throws HeadlessException {
        this.setTitle("CalcClient");
        this.setSize(300, 100);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());


        c.add(search);
        c.add(word);
        c.add(result);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            socket = new Socket("localhost", 9999);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("서버 연결됨");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        word.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputWord = word.getText();
                    bufferedWriter.write(inputWord + "\n");
                    bufferedWriter.flush();
                    String serverResult = bufferedReader.readLine();
                    result.setText(serverResult);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        new WordClient();
    }
}

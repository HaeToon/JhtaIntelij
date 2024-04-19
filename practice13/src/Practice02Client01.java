import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Practice02Client01 extends JFrame {
    Socket socket;
    BufferedWriter bufferedWriter;
    String result;
    String operation;

    public Practice02Client01() throws HeadlessException {
        this.setTitle("Client01");
        this.setSize(400, 100);

        Container c = this.getContentPane();
        JTextField textField01 = new JTextField(5);
        JTextField textField02 = new JTextField(5);
        JTextField textField03 = new JTextField(5);
        JTextField textField04 = new JTextField(5);
        JLabel jLabel = new JLabel("=");
        JButton btn = new JButton("계산");

        c.setLayout(new FlowLayout());

        c.add(textField01);
        c.add(textField02);
        c.add(textField03);
        c.add(jLabel);
        c.add(textField04);
        c.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(textField01.getText());
                int b = Integer.parseInt(textField03.getText());
                String operation = textField02.getText();
                if (operation.equals("+")) {
                    textField04.setText(Integer.toString(a + b));
                } else if (operation.equals("-")) {
                    textField04.setText(Integer.toString(a - b));
                } else if (operation.equals("*")) {
                    textField04.setText(Integer.toString(a * b));
                } else if (operation.equals("/")) {
                    textField04.setText(Integer.toString(a / b));
                }
                result = textField01.getText() + textField02.getText() + textField03.getText()+jLabel.getText() + textField04.getText();
                System.out.println(result);
                try {
                    bufferedWriter.write(result);
                bufferedWriter.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            socket = new Socket("localhost", 9999);
            System.out.println("서버에 연결되었습니다.");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        new Practice02Client01();
    }
}

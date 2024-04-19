import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class CalcClient extends JFrame {
    private JTextField first= new JTextField(10);
    private JTextField operator= new JTextField(10);
    private JTextField second= new JTextField(10);
    private JLabel equal= new JLabel("=");
    private JTextField result= new JTextField(10);
    private JButton btn = new JButton("계산");
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;


    public CalcClient() throws HeadlessException {
        this.setTitle("CalcClient");
        this.setSize(600,100);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(first);
        c.add(operator);
        c.add(second);
        c.add(equal);
        c.add(result);
        c.add(btn);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            socket = new Socket("localhost",9999);
           bufferedReader=new BufferedReader( new InputStreamReader(socket.getInputStream()));
           bufferedWriter= new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("서버 연결됨");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bufferedWriter.write(first.getText()+"\n");
                    bufferedWriter.write(operator.getText()+"\n");
                    bufferedWriter.write(second.getText()+"\n");
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
        new CalcClient();
    }
}

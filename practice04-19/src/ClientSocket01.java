import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;



public class ClientSocket01 extends JFrame implements ActionListener {
    Socket socket;
    JTextField textField;
    TextArea02 textArea02;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    class TextArea02 extends JTextArea implements Runnable {

        @Override
        public void run() {
            String msg = null;
            while(true){
                try {
                   msg= bufferedReader.readLine();
                    Thread.sleep(10);
                   this.append("Server : "+msg +"\n");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public ClientSocket01() throws HeadlessException {
        this.setTitle("Client");
        this.setSize(300, 300);

        Container c = this.getContentPane();
        textField = new JTextField(20);
        textArea02 = new TextArea02();

        c.add(textField, BorderLayout.SOUTH);
        c.add(textArea02, BorderLayout.CENTER);

        textField.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            socket = new Socket("localhost", 9999);
            textArea02.append("서버 연결됨. \n");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(textArea02);
        thread.start();
    }

    public static void main(String[] args) {
        new ClientSocket01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = textField.getText();
        try {
            bufferedWriter.write(msg + "\n");
            bufferedWriter.flush();
            textArea02.append("Client : " + msg + "\n");
            textField.setText("");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

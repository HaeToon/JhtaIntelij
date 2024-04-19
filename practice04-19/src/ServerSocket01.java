import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSocket01 extends JFrame implements ActionListener {
    ServerSocket serverSocket;
    Socket socket;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    JTextField textField;
    TextArea01 textArea01;

    class TextArea01 extends JTextArea implements Runnable {

        @Override
        public void run() {
            String msg = null;
            while (true) {
                try {
                    msg = bufferedReader.readLine();
                    Thread.sleep(10);
                    this.append("Client" + msg + "\n");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public ServerSocket01() throws HeadlessException {
        this.setTitle("SEVER");
        this.setSize(300, 300);

        Container c = this.getContentPane();
        textField = new JTextField(20);
        textArea01 = new TextArea01();

        c.add(textField, BorderLayout.SOUTH);
        c.add(textArea01, BorderLayout.CENTER);

        textField.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            serverSocket = new ServerSocket(9999);
            socket = serverSocket.accept();
            textArea01.append("클라이언트 연결 되었습니다. \n");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(textArea01);
        thread.start();
    }

    public static void main(String[] args) {
        new ServerSocket01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = textField.getText();
        try {
            bufferedWriter.write(msg+"\n");
            bufferedWriter.flush();
            textArea01.append("Server : "+msg+"\n");
            textField.setText("");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

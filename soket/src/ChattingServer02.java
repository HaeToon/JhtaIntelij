import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer02 extends JFrame {
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    ServerSocket listener;
    Receiver receiver;
    Socket socket;
    class Receiver extends JTextArea implements Runnable{

        @Override
        public void run() {
            while(true){
                String msg = null;
                try {
                   msg= bufferedReader.readLine();
                   this.append("Client : "+msg+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public ChattingServer02() throws HeadlessException {
        this.setTitle("ChattingServer02");
        this.setSize(300,300);

        Container c = this.getContentPane();
        JTextField sender = new JTextField(20);
        receiver = new Receiver();

        c.add(sender,BorderLayout.SOUTH);
        c.add(receiver,BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            listener = new ServerSocket(9999);
            socket=listener.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            receiver.append("클라이언트가 연결되었습니다. \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();
    }

    public static void main(String[] args) {
        new ChattingServer02();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer01 extends JFrame implements ActionListener {
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    ServerSocket listener;
    Socket socket;
    JTextField sender;
    Receiver receiver;
    class Receiver extends JTextArea implements Runnable {

        @Override
        public void run() {
            while(true){
            String msg=null;
                try {
                    Thread.sleep(100);
                    msg=bufferedReader.readLine();
                    this.append("Client : "+msg+"\n");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public ChattingServer01() throws HeadlessException {
        this.setTitle("Servert01-Chatting");
        this.setSize(300,300);

        Container c = this.getContentPane();
        sender = new JTextField(20);


        receiver = new Receiver();
        receiver.setEditable(false);
        sender.addActionListener(this);


        c.add(sender,BorderLayout.SOUTH);
        c.add(receiver,BorderLayout.CENTER);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();

        try {
            listener = new ServerSocket(9999);
            socket = listener.accept();
            receiver.append("클라이언트가 연결되었습니다. \n");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();
    }

    public static void main(String[] args) {
        new ChattingServer01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = sender.getText();
        if(!msg.equals(null)) {
            try {
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                receiver.append("Server : " + msg + "\n");
                sender.setText(null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

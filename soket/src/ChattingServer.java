import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer extends JFrame implements ActionListener {
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    ServerSocket listener;
    Socket socket; //연결된 소켓
    JTextField sender;
    Receiver receiver;

    class Receiver extends JTextArea implements Runnable {


        @Override
        public void run() {
            while (true) {
                String msg = null;
                //계속 해야하는것
                try {
                    Thread.sleep(100);
                    msg = bufferedReader.readLine();
                    this.append("Client :" + msg+"\n");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public ChattingServer() throws HeadlessException {
        this.setTitle("서버 채팅");
        this.setSize(300, 300);

        Container c = this.getContentPane();
        sender = new JTextField(20);
        receiver = new Receiver();
        receiver.setEditable(false); //receiver TextArea에 글작성 못하게하는것.

        c.add(sender, BorderLayout.SOUTH);
        c.add(new JScrollPane(receiver), BorderLayout.CENTER);

        sender.addActionListener(this);



        this.setFocusable(true);
        this.requestFocus();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            listener = new ServerSocket(9999);
            socket = listener.accept();
            receiver.append("클라이언트 소켓 연결되었습니다. \n");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();

    }

    public static void main(String[] args) {
        new ChattingServer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = sender.getText();
        if(!msg.equals("")) {
            try {
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                receiver.append("Server : " + msg + "\n");
                sender.setText("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

}

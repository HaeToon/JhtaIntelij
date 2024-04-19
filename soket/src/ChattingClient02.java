import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChattingClient02 extends JFrame implements ActionListener {
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    JTextField sender;
    Receiver receiver;
    Socket socket;
    class Receiver extends JTextArea implements Runnable{

        @Override
        public void run() {

        }
    }
    public ChattingClient02() throws HeadlessException {
        this.setTitle("ChattingClient02");
        this.setSize(300,300);

        Container c = this.getContentPane();
        sender = new JTextField(20);
        receiver = new Receiver();

        sender.addActionListener(this);

        c.add(sender,BorderLayout.SOUTH);
        c.add(receiver,BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            socket=new Socket("localhost",9999);
            receiver.append("서버와 연결되었습니다.");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();

    }

    public static void main(String[] args) {
        new ChattingClient02();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = sender.getText();
        if(!msg.equals(null)) {
            try {
                bufferedWriter.write(msg);
                bufferedWriter.flush();
                sender.setText(null);
                receiver.append("Client : "+msg +"\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

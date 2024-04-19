import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;


public class ChattingClient01 extends JFrame implements ActionListener {
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    Socket socket;
    JTextField sender;
    Receiver receiver;
    class Receiver extends JTextArea implements Runnable{

        @Override
        public void run() {
            while (true){
                String msg = null;
                try {
                    Thread.sleep(100);
                    msg=bufferedReader.readLine();
                    this.append("Server : "+msg+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public ChattingClient01() throws HeadlessException {
        this.setTitle("Client01-Chatting");
        this.setSize(300,300);

        Container c = this.getContentPane();

        sender = new JTextField(20);

        receiver = new Receiver();
        receiver.setEditable(false);


        c.add(sender,BorderLayout.SOUTH);
        c.add(receiver,BorderLayout.CENTER);

        sender.addActionListener(this);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();

        try {
            socket = new Socket("localhost",9999);
            receiver.append("서버에 연결했습니다. \n");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();
    }

    public static void main(String[] args) {
        new ChattingClient01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = sender.getText();
        if(!msg.equals("")) {
            try {
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                receiver.append("Client : "+msg+"\n");
                sender.setText(null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

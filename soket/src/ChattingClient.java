import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingClient extends JFrame implements ActionListener {
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    Socket socket; //연결된 소켓
    JTextField sender;
    Receiver receiver;
    class Receiver extends JTextArea implements Runnable {
        @Override
        public void run() {
            while(true){
                String msg=null;
                //계속 해야하는것
                try {
                    Thread.sleep(100);
                    msg = bufferedReader.readLine(); //bufferReader에서 읽은 것이 msg가 됨
                    this.append("Server : "+msg+"\n");  //msg를 JTextArea에 표시
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public ChattingClient() throws HeadlessException {
        this.setTitle("클라이언트 채팅");
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
            socket = new Socket("localhost",9999);
            receiver.append("서버에 연결 되었습니다. \n"); //1명이 접속할때 여러명이 접속할때는?? 반복문 while돌려서 list에담기.
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();

    }

    public static void main(String[] args) {
        new ChattingClient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = sender.getText();
        if (!msg.equals("")) {
            try {
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                receiver.append("Client : "+msg+"\n");
               int posY = receiver.getText().length(); //길이
               receiver.setCaretPosition(posY); // 길이만큼 스크롤 내리기
                sender.setText(null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}

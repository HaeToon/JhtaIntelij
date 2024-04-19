import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Practice02Server extends JFrame {
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader bufferedReader;
    String msg;
    private List<Object>socketList = new ArrayList<>();
    class TextArea01 extends JTextArea implements Runnable{

        @Override
        public void run() {
            while(true){
                this.append(msg);
            }
        }
    }
    public Practice02Server() throws HeadlessException {
        this.setTitle("계산서버");
        this.setSize(300,500);

        Container c = new Container();
        TextArea01 textArea = new TextArea01();
        c.add(textArea,BorderLayout.CENTER);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        try {
            serverSocket = new ServerSocket(9999);
            serverSocket.accept();
            System.out.println("클라이언트가 연결되었습니다.");
            textArea.append("클라이언트가 연결되었습니다.");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                msg = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        new Practice02Server();
    }
}

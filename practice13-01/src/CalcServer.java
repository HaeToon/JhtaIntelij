import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer extends JFrame {
    ServerSocket listener;
    private JTextArea textArea = new JTextArea();
    public CalcServer() throws HeadlessException {
        this.setTitle("CalcServer");
        this.setSize(400,500);

        Container c = this.getContentPane();
        c.add(new JScrollPane(textArea));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        new ServerAcceptThread().start();
    }
    class ServerAcceptThread extends Thread{
        @Override
        public void run() {
                ServerSocket listener;
                        Socket socket;
            try {
                    listener = new ServerSocket(9999);
                while(true) {
                    socket = listener.accept();
                    textArea.append("클라이언트 접속됨");
                    new CalcThread(socket).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    class CalcThread extends Thread{ //서버에 접속해온 클라이언트에게 받은 숫자로 계산결과를 보내준다.
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private Socket socket;


        public CalcThread(Socket socket) {
            this.socket = socket;
            try {
                bufferedReader=new BufferedReader( new InputStreamReader(socket.getInputStream()));
            bufferedWriter= new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            while(true){
                try {
                    String first = bufferedReader.readLine();
                    String operator = bufferedReader.readLine();
                    String second = bufferedReader.readLine();
                    String result="";
                    if(operator.equals("+")){
                    result = " " + (Integer.parseInt(first)+Integer.parseInt(second));
                    }
                    bufferedWriter.write(result+"\n");
                    bufferedWriter.flush();
                    textArea.append(result+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) {
        new CalcServer();
    }
}

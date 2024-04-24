import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("클라이언트 연결대기중");
            socket = serverSocket.accept();
            System.out.println("클라이언트 연결 완료");
            Scanner sc = new Scanner(System.in);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true) {
                String sendMsg = sc.nextLine();
                String receiveMsg = bufferedReader.readLine();
                System.out.println(receiveMsg);
            }
            //여기서 데이터 보내면 서버에서 받을수 있다.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

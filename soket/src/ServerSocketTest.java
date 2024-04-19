import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {
    public static void main(String[] args) {
        ServerSocket listener;
        Socket socket;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter = null;
        Scanner sc = new Scanner(System.in);
        try {
            listener = new ServerSocket(9999);
            System.out.println("나는 서버 소켓입니다. 클라이언트의 연결을 기다리고있습니다.");
            socket = listener.accept();
            System.out.println("클라이언트 소캣 연결됨");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String inputMsg = bufferedReader.readLine();
                System.out.println("socket에서 보낸 msg ==" +inputMsg);
                String outputMsg = sc.nextLine();
                bufferedWriter.write(outputMsg +"\n"); // \n 줄바꿈
                bufferedWriter.flush(); //buffer가 다 차지않더라도 남는은것을 한번에 보내는것
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

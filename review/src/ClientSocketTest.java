import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketTest {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter;
        Socket socket;
        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 9999);
            System.out.println("서버 연결됨.");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String sendMsg = sc.nextLine();
                bufferedWriter.write(sendMsg + "\n ");
                bufferedWriter.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args){
        BufferedReader bufferedReader;
        Socket socket;
        try {
            socket= new Socket("localhost",9999);
            System.out.println("서버 연결됨.");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputMsg;
            while(true){
               inputMsg = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.io.IOException;
import java.net.Socket;

public class Practice01Client {
    Socket socket;

    public Practice01Client() {
        try {
            socket = new Socket("localhost",9999);
            System.out.println("서버에 접속했습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Practice01Client();
    }
}

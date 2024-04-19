import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Practice01 {
    ServerSocket serverSocket;
    Socket socket;
    private int num=0;

    public Practice01() {
        try {
            serverSocket = new ServerSocket(9999);
            serverSocket.accept();
            System.out.println("클라이언트가 연결되었습니다.");
            while(num<10){
                Thread.sleep(1000);
                num++;
                System.out.println(num);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        new Practice01();
    }
}

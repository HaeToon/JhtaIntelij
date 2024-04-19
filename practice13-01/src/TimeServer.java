import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TimerThread extends Thread {
    private BufferedWriter bufferedWriter;

    public TimerThread(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    int num = 0;

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                bufferedWriter.write(Integer.toString(i) + "\n");
                bufferedWriter.flush();
                Thread.sleep(500);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//        while(num<10) {
//            num++;
//            System.out.println(num);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//}
}

public class TimeServer {
    public static void main(String[] args) {
        ServerSocket listener;
        Socket socket;
        BufferedWriter bufferedWriter;
        try {
            listener = new ServerSocket(9999);
            socket = listener.accept();
            System.out.println("클라이언트 연결됨");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            TimerThread thread = new TimerThread(bufferedWriter);
            thread.start();
//        bufferedWriter.write(num+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

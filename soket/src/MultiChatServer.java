import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//socket이 전송한 데이터들을 실시간으로 서버에 전달하고 서버가 데이터를받아서
//나머지 애들에게 싹다 보내주기

public class MultiChatServer {
    // 여러소캣이 접속할경우 담아두는 공간
    List<ServerWorker> socketList = new ArrayList<>();
    ServerSocket listener;
        String userName;
    class ServerWorker implements Runnable {
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        Socket socket;
        public ServerWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //Reader , Writer txt를 주고받는 보조스트림.
            try {
                bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
               userName = bufferedReader.readLine(); //클라이언트로부터 입력받은 이름
                broadCasting(userName+"님이 입장하셨습니다. \n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            while(true){
                //데이터를 읽어서 나머지에게 실시간전송해주는 코드 작성
                try {
                    String inputMsg = bufferedReader.readLine();
                    broadCasting(inputMsg); //읽고나서 바로 모든 연결된 socket들에게 송출 함.
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public MultiChatServer() {
        try {
            listener = new ServerSocket(9999);
//            socket= listener.accept(); //하나의 클라이언트만 받을수있음
            while (true) {
                Socket socket = listener.accept(); //여러개의 클라이언트를 받을수있음.
                ServerWorker serverWorker = new ServerWorker(socket);
                socketList.add(serverWorker);
                Thread thread = new Thread(serverWorker);
                thread.start(); //실시간으로 데이터 주고받기.
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void broadCasting(String msg){
        //데이터 송출
        for(int i=0; i<socketList.size(); i++){
        ServerWorker serverWorker = socketList.get(i);
            try {
                serverWorker.bufferedWriter.write(msg+"\n");
                serverWorker.bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void main(String[] args){
        new MultiChatServer();
    }
}

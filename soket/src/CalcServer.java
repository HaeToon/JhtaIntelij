import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.StringTokenizer;

public class CalcServer {
    public static void main(String[] args){
        ServerSocket listener;
        Socket socket;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            listener = new ServerSocket(9999);
            socket=listener.accept();
            System.out.println("연결");
           bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           while(true){
               String inputMsg = bufferedReader.readLine();
               StringTokenizer stringTokenizer = new StringTokenizer(inputMsg," ");
               int num01 = Integer.parseInt(stringTokenizer.nextToken());
               String operator = stringTokenizer.nextToken();
               int num02 = Integer.parseInt(stringTokenizer.nextToken());
               String result = Integer.toString(num01+num02);
               System.out.println(inputMsg);
               bufferedWriter.write(result+"\n");
               bufferedWriter.flush();
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

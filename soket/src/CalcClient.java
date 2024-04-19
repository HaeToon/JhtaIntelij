import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        try {
            Socket socket = new Socket("localhost",9999); //localhost또는 ip주소
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            while(true){
                String outputMsgh = sc.nextLine(); //enter치는 동시에 외부로 송출
                bufferedWriter.write(outputMsgh+"\n");
                bufferedWriter.flush();
                String result = bufferedReader.readLine();
                System.out.println("계산결과 :"+result);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

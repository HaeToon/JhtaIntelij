import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketTest {
    public static void main(){
//        new Socket("127.0.0.1",port); //같은 컴퓨터내의 경우 127.0.0.1
//        new Socket("localhost",port); //같은 컴퓨터내의 경우 127.0.0.1
        Socket socket;
        //데이터보내기
        //글자쓰기
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader;
        Scanner sc = new Scanner(System.in);

        try {
           socket = new Socket("localhost",9999); //같은 컴퓨터내의 경우
            //1.바깥으로 나갈때 byte 2.OutputStreamWriter(socket.getOutputStream()) text한글자씩 내보내기
            //3. bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())) buffer로 묶어서 한번에 내보내기

        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                //서버에서 보내기 받기
                String outputMsg = sc.nextLine();
                bufferedWriter.write(outputMsg +"\n"); // \n 줄바꿈
                bufferedWriter.flush(); //buffer가 다 차지않더라도 남는은것을 한번에 보내는것
                //내가 보내기  받기
                String inputMsg = bufferedReader.readLine();
                System.out.println("socket에서 보낸 msg ==" +inputMsg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

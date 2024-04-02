import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\jhta\\Desktop\\sample02.txt");
            //줄바꿈 \r \n 캐리지 리턴
            while(true) {
                String line = sc.nextLine();
                if(line.length()==0) break;
                fileWriter.write(line,0,line.length()); // 여러줄 입력 및 0시작 line.length 까지
                fileWriter.write("\r\n",0,2); // \r window줄바꿈 \n mac줄바꿈 2개이므로 0~2까지
            }
            //fileWriter.write("동해물과 백두산이 \r 마르고 닳도록 \r 하느님이 보우하사 \r 우리나라 만세");
//            fileWriter.write("하느님이 보우하사 우리나라 만세");
            //간단한 text database
            fileWriter.close();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        }
    }
}

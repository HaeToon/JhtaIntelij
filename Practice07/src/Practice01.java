import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("c:\\Temp\\phone.txt");
            while(true){
                System.out.println("이름 , 전화번호 : ");
                String line = scanner.nextLine();
                if(line.equals("그만"))break;
                fileWriter.write(line,0,line.length());
                fileWriter.write("\r\n",0,2);
            }
            fileWriter.close();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        }

    }
}

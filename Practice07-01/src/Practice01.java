import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        File file = new File("c:\\Temp\\phone.txt");
        try {
            fileWriter = new FileWriter("c:\\Temp\\phone.txt");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("이름 , 전화번호를 입력해 주세요");
                String txt = scanner.nextLine();
                if(txt.equals("그만"))break;
                fileWriter.write(txt+"\r\n");
            }
            System.out.println("저장되었습니다.");
            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

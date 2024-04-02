import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Practice02 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("c:\\Temp\\phone.txt");
            int c;  // fileReader 는 file을 int로 읽어들임.
            while((c=fileReader.read())!=-1){ // eof end of file 마지막 파일은 -1을 리턴함.
                System.out.print((char)c);   // int형 fileRead값을 char값으로 변환해줘야 알아볼수있음.
            }
        } catch (FileNotFoundException e) {  // 파일이 경로에 없을때 발생
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    //Reader /Writer 는 문자데이터를 읽고 쓰겠다는 의미.
    public static void main(String[] args) {
        //자바에서 입출력 관련된것들은 전부다 try catch 해야함.

        try { //시도했을때 없다면 catch 함.
            FileReader fileReader = //new FileReader("C:\\Windows\\system.ini");
            new FileReader("C:\\Users\\jhta\\Desktop\\sample.txt");
            //출력
            // 읽을때는 글자하나하나를 int로 읽  음
            int c;
            // eof end of file 은 마지막에 return 을 -1 을 리턴함.
            while((c = fileReader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("정해진 경로에 파일이 없습니다.");
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("파일 읽기를 실패했습니다.");
        }
    }
}

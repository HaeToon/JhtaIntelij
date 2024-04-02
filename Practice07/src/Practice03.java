import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Practice03 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("c:\\windows\\system.ini");
            File file = new File("c:\\windows\\system.ini");
            int c;
            while((c=fileReader.read())!=-1){
                if(c>='a' && c<'z'){
                    System.out.print((char)(c-32));
                }else {
                    System.out.print((char)c);
                }
            }
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

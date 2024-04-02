import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\jhta\\Desktop\\sample02.txt");
          //  String txt = "\uD83D\uDE16"; //영어는 1바이트 한글은 3바이트
         //   byte bytes[] = txt.getBytes();  // 문자열을 바이트로 바꿈
            byte bytes[] = {-16, -97, -104, -106};
            System.out.println(Arrays.toString(bytes));
            fileOutputStream.write(bytes);  //
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

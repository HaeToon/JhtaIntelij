import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedOutputSteamTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        int c;
        try {
            fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\anthem.txt");
            BufferedOutputStream bufferedOutStream = new BufferedOutputStream(System.out, 3);
            while ((c = fileReader.read()) != -1) {
                bufferedOutStream.write(c);
            }
            bufferedOutStream.flush(); //강제로  buffer에 남은것을 밀어넣는것.
//            fileReader.close();
//            bufferedOutStream.close();
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

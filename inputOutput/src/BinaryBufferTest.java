import java.io.*;

public class BinaryBufferTest {
    public static void main(String[] args) {
        File orginalSc = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\js-lecture\\portfolio\\image\\01.webp");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolder\\01.webp");
        int c;
        {
            try {
                FileInputStream fileInputStream = new FileInputStream(orginalSc); //이미지는 read write x fileinpputstream사용
                FileOutputStream fileOutputStream = new FileOutputStream(copy);
                byte buffer [] = new byte[1024*10];
                while(true){
                 int num = fileInputStream.read(buffer);
                    fileOutputStream.write(buffer,0,num);
                    if(num<buffer.length)break;
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
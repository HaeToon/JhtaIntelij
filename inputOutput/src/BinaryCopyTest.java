import java.io.*;

public class BinaryCopyTest {
    public static void main(String[] args) {
        File orginalSc = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\js-lecture\\portfolio\\image\\02.webp");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolder\\02.webp");
        int c;
            try {
                FileInputStream fileInputStream = new FileInputStream(orginalSc); //이미지는 read write x fileinpputstream사용
                FileOutputStream fileOutputStream = new FileOutputStream(copy);
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write((byte) c);
                    System.out.print((byte) c);
                }
                fileInputStream.close();
                fileOutputStream.close();
                //하나씩 읽어오기때문에 속도가 느리다.
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}

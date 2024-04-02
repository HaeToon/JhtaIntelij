import java.io.*;

public class Practice0702 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\jhta\\Desktop\\myFolder\\02.webp");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolderCopy\\copy.webp");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null; // Buffered는 보조스트림.
        try {
            FileInputStream fileInputStream = new FileInputStream(file); // FileReader는 이미지를 읽지못함. 문자만
            FileOutputStream fileOutputStream = new FileOutputStream(copy);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            System.out.println(file.length()); // file의 원본 크기를 리턴함.
            long percent = file.length() / 10;
            byte buffer[] = new byte[1024]; //1024 = 1kb
            int count = 0;
            long process = 0;
            int num =0;
            while (true) {
                count = fileInputStream.read(buffer, 0, buffer.length);
                if (count == -1) break;
                if (count > 0) {
                    fileOutputStream.write(buffer, 0, buffer.length);

                }
                process+=count;
                if(process>percent){ // percent*num
                    System.out.print("*");
                    process=0;      //num ++;
                }
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

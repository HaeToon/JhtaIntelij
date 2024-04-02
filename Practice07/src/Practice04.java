import java.io.*;

public class Practice04 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("c:\\windows\\system.ini");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out,1);
            File file = new File("c:\\windows\\system.ini");
            int c;
            while((c=fileReader.read())!=-1){
                bufferedOutputStream.write(c);
            }
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

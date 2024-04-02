import java.io.*;

public class TextCopyTest {
    public static void main(String[] args) {
        File original = new File("C:\\Windows\\system.ini");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolder\\system.ini");
        int c;
        try {
            FileReader fileReader = new FileReader(original);
            FileWriter fileWriter = new FileWriter(copy);
            while((c=fileReader.read())!=-1){
                fileWriter.write((char)c);
            }
            fileWriter.close(); //close 가 뭔지 모르겠음
            fileReader.close();
//            while(true){
//                c=fileReader.read();
//                if(c==-1)break;
//                fileWriter.write((char)c);
//            }
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("경로에 파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

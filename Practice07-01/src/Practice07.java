import java.io.*;

public class Practice07 {
    public static void main(String[] args) { // FileReader Writer 는 문자만 가능함. 이미지파일을 복사할수없음.. 틀린이유
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        File original = new File("C:\\Users\\jhta\\Desktop\\myFolder\\02.webp");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolderCopy\\02.webp");
        int c;
        try {
            fileReader = new FileReader(original);
            fileWriter = new FileWriter(copy);
            while((c=fileReader.read())!=-1){
                fileWriter.write((char)c);
            }
            fileWriter.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Practice05 {
    public static void main(String[] args) {
        try {
            FileReader fileReader01 = new FileReader("C:\\Windows\\system.ini");
            FileReader fileReader02 = new FileReader("C:\\Users\\jhta\\Desktop\\myFolder\\system.ini");
            File file01 = new File("C:\\Windows\\system.ini");
            File file02 = new File("C:\\Users\\jhta\\Desktop\\myFolder\\system.ini");
            int c,d;
            System.out.println(file01.getName());
            System.out.println(file02.getName());
            if(file01.getName().equals(file02.getName())&& file01.toString().equals(file02.toString())) {
                System.out.println("파일이 같습니다.");
            }else {
                System.out.println("파일이 다릅니다.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

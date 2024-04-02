import java.io.*;
import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        File file = new File("c:\\windows\\system.ini");
        int c;
        try {
            FileReader fileReader = new FileReader("c:\\windows\\system.ini");
            while((c=fileReader.read())!=-1) {
               char charactor = (char)c;
              char changedCharactor = Character.toUpperCase(charactor);
                System.out.print(changedCharactor);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
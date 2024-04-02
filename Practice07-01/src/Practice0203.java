import java.io.*;
import java.util.Scanner;

public class Practice0203 {
    public static void main(String[] args) {
        File file = new File("c:\\Temp\\phone.txt");
        try {
            FileReader fileReader = new FileReader(file);
            Scanner sc = new Scanner(fileReader);
            int num=1;
            while(sc.hasNext()){
                String line = sc.nextLine();
                System.out.printf("%02d 번 %s \r\n",num,line);
                num++;
            }
            sc.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

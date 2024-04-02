import java.io.*;
import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
       FileReader fileReader = null;
       File file = new File("c:\\Temp\\phone.txt");
        try {
            fileReader = new FileReader("c:\\Temp\\phone.txt");
            System.out.println("출력");
            int c =0;
//            while((c=fileReader.read())!=-1){
//                System.out.print((char)c);
//            }
            while(true){  //위와 같은 반복문
                c=fileReader.read();
                if(c==-1)break;
                System.out.print((char)c);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

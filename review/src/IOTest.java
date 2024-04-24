import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args){
        //Reader
//        try {
//            //문자열 읽기
//            FileReader fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\sampleKor.txt");
//            int c;
//            while((c =fileReader.read())!=-1){
//                System.out.print((char)c);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //Write
//        Scanner sc = new Scanner(System.in);
//        try {
//            FileWriter fileWriter = new FileWriter("C:\\Users\\jhta\\Desktop\\sampleEng.txt");
//            fileWriter.write("허태훈 : 5점");
//            while(true){
//                String line = sc.nextLine();
//                fileWriter.write(line,0,line.length()); //0~line의 길이까지
//                fileWriter.write("\r\n",0,2); //줄바꿈
//                if(line.equals(""))break;
//            }
//            fileWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //txt파일복사
//       File file = new File("C:\\Users\\jhta\\Desktop\\sampleEng.txt");
//       File copyFile = new File("src/copy.txt");
//        try {
//            FileReader fileReader = new FileReader(file);
//            FileWriter fileWriter = new FileWriter(copyFile);
//            while((c=fileReader.read())!=-1){
//                System.out.println((char)c);
//                fileWriter.write((char)c);
//            }
//            fileWriter.close();
//            fileReader.close();
//            System.out.println(fileReader.read());;
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        File img = new File("images/01.webp");
        File copyFile = new File("copy.jpg");

        int c;
        try {
            FileInputStream fileInputStream = new FileInputStream(img);
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
            byte buffer[] = new byte[1024];
//            while((c=fileInputStream.read())!=-1){
//                fileOutputStream.write((byte)c);
//            }
            while(true){
                int num =fileInputStream.read(buffer);
                fileOutputStream.write(buffer,0,num);
                if(num<buffer.length) break;
            }
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

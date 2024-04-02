import java.io.*;
import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        File file = new File("c:\\windows\\system.ini");
        try {
            FileReader fileReader = new FileReader(file);
            Scanner sc = new Scanner(fileReader); // System.in
            int lineNum =1;
            while(sc.hasNext()){ // hasNext = 다음줄이 있으면
                String line = sc.nextLine(); // 한줄읽기  Scanner 를통해서 라인을 읽을수있음.
                System.out.printf("%02d : %s \r\n",lineNum,line);
//                System.out.println(lineNum+":"+line);
                lineNum++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
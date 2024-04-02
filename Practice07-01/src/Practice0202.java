import java.io.*;

public class Practice0202 {
    public static void main(String[] args) {
        //Reader Writer 는 char만 읽을수있음.
        BufferedReader bufferedReader = null;
       FileReader fileReader = null;
       File file = new File("c:\\Temp\\phone.txt");
        int c;
        try {
            fileReader = new FileReader("c:\\Temp\\phone.txt");
            bufferedReader = new BufferedReader(fileReader);
            System.out.println("출력");
            while(true){  //위와 같은 반복문
                String line =bufferedReader.readLine();  // char형이아닌 string형
                if(line.equals(null))break;
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

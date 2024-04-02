import java.io.*;
import java.util.Scanner;

public class Practice06 {
    private static void writeFie(FileReader fileReader , FileWriter fileWriter){
        char buffer [] = new char[50];
        int c=0;
        while(true){
            try {
                if (!((c=fileReader.read(buffer,0,buffer.length))!=-1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(c>0) {
                try {
                    fileWriter.write(buffer,0,c);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        //파일을 읽어서 새로운 파일로 만들기.
        //파일 읽기 , 새로운 파일 만들기
        FileReader fileReader01 = null;
        FileReader fileReader02 = null;
        FileWriter fileWriter = null;
        Scanner sc = new Scanner(System.in);

        try {
            fileReader01 = new FileReader("C:\\Users\\jhta\\Desktop\\myFolder\\elvis01.txt");
            fileWriter = new FileWriter("C:\\Users\\jhta\\Desktop\\myFolder\\new.txt.txt");
//            fileReader02 = new FileReader("C:\\Users\\jhta\\Desktop\\myFolder\\elvis02.txt");
            writeFie(fileReader01,fileWriter);
            fileReader01 = new FileReader("C:\\Users\\jhta\\Desktop\\myFolder\\elvis02.txt");
            writeFie(fileReader01,fileWriter);
            fileWriter.close();
            fileReader01.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

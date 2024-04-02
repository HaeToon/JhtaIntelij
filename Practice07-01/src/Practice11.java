import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice11 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        File file = new File("C:\\Temp\\words.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner sc = new Scanner(fileInputStream);
            while(sc.hasNext()){
                wordList.add(sc.nextLine());
            }
            sc.close();
            Scanner sc02 = new Scanner(System.in);
            while(true){
                System.out.println("찾을 단어를 입력해 주세욧");
                String searchWord = sc02.next();
                if(searchWord.equals("그만"))break;
                boolean isSearch =false;
                for(int i=0; i<wordList.size(); i++) {
                    if(wordList.get(i).startsWith(searchWord)){
                        System.out.println(wordList.get(i));
                        isSearch=true;
                    }
                }
                if(isSearch==false){
                    System.out.println("찾는단어가 없습니다.");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        Map<String,String>map = new HashMap<>();

        File file = new File("src/phone.txt");
        try {
            Scanner phoneBook = new Scanner(file);
            while (phoneBook.hasNext()){
//                System.out.println(phoneBook.nextLine());  // nextLine 으로 읽으면 공백도 읽어버림
//                System.out.println(phoneBook.next());   //next 로 읽으면 공백은 무시함.
                String name = phoneBook.next();
                String tel = phoneBook.next();
                map.put(name,tel);
            }
            phoneBook.close();
            System.out.println("총 "+map.size()+"개의 전화번호가 있습니다.");
            Scanner sc=new Scanner(System.in);
            while(true){
                System.out.println("이름을 입력해 주세요 >>");
                String name = sc.next();
                if(name.equals("그만"))break;
                if(map.get(name)==null){
                    System.out.println(name + "님은 없는 사람입니다.");
                }else {
                    String tel = map.get(name);
                    System.out.println(name +"님의 전화번호는 "+ map.get(name)+"입니다.");
                    System.out.println(name +"님의 전화번호는 "+ tel+"입니다.");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

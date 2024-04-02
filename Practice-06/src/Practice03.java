import java.util.*;

public class Practice03 {



    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Map<String,String>country = new HashMap<String,String>();
        System.out.println("나라 이름과 인구를 입력하세요. ex)Korea 5000");
        while(true){
            System.out.println("나라 이름, 인구 >>>");
            String text = sc.nextLine();
            if(text.equals("그만")){
                break;
            }
            StringTokenizer st = new StringTokenizer(text," ");
            country.putIfAbsent(st.nextToken(), st.nextToken());
        }
        while(true){
            System.out.println("검색할 나라를 입력해주세요");
            String text = sc.nextLine();
            if(text.equals("그만")){
                System.out.println("종료합니다.");
                break;
            }else if(country.containsKey(text)){
                System.out.println(text+"나라의 인구는"+country.get(text));
            }else {
                System.out.println(text+"나라는 없습니다.");
            }
        }
    }
}

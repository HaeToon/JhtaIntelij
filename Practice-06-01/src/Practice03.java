import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("나라이름과 인구수를 입력해 주세요 ex)korea 5000");
        Map<String, Integer> nationList = new HashMap<>();
        while (true) {
            System.out.println("나라이름 , 인구 >>");
            String nation = scanner.next();
            if (nation.equals("그만")) {
                break;
            }
            int num = scanner.nextInt();
            nationList.put(nation, num);
        }
        while (true) {
            System.out.println("검색할 나라를 입력해주세요.");
            String search = scanner.next();
            if (search.equals("그만")) {
                break;
            }
            if (nationList.containsKey(search)) {
                Integer num = nationList.get(search);
                if (num != null) {
                    System.out.println(search + "의 인구는" + num + "입니다.");
                } else {
                    System.out.println(search + "은 저장되어있지 않습니다.");
                }
            }
//            if(nationList.containsKey(search)){
//                int num=nationList.get(search);
//                System.out.println(search+"의 인구는"+num+"입니다.");
//            }else {
//                System.out.println(search + "은 저장되어있지 않습니다.");
//           }
        }
    }
}

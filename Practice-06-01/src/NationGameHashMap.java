import java.util.*;

public class NationGameHashMap {
    private HashMap<String,String> nationList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public NationGameHashMap() {
        nationList.put("미국","워싱턴");
        nationList.put("영국","런던");
        nationList.put("중국","베이징");
    }
    public void read(){
        int num = nationList.size();
        System.out.println("현재"+num+"개의 나라와 수도가 저장되어 있습니다.");
        while(true){
            System.out.println((num+1)+"번째 나라와 수도 입력 ==>");
            String country = scanner.next();
            if(country.equals("그만")) {
                System.out.println("입력을 종료합니다.");
                break;
            }
            String capital = scanner.next();
//            if(contain(country)) {
//                System.out.println(country+"는 이미 있습니다.");
//                num--;
//                continue; // 중복하는게 존재하면 건너뛰어라.
//            }
            if(nationList.containsKey(country)){
                System.out.println(country+"는 이미 있습니다.");
                num--;
            }else {
                nationList.put(country,capital);
                num++;
            }
        }
    }

    void run (){
        System.out.println("나라맞추기 게임을 시작합니다.");
        while(true){
            System.out.println("입력 : 1 퀴즈 : 2 종료 : 3");
            int num = scanner.nextInt();
            if(num==3){
                System.out.println("나라맞추기 게임을 종료합니다.");
//                break;
                return;
            }else if(num==1){
                read();
            }else if(num==2){

            }else{
                System.out.println("잘못입력하셨습니다.");
            }
        }
    }
}

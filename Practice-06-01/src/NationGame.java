import java.util.*;

public class NationGame {
//    private Vector<Nation> nationList = new Vector<>();//Vector는 거의안씀
    private List<Nation> nationList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public NationGame() {
        nationList.add(new Nation("미국","워싱턴"));
        nationList.add(new Nation("중국","베이징"));
        nationList.add(new Nation("한국","서울"));
        nationList.add(new Nation("일본","도쿄"));
        nationList.add(new Nation("호주","캔버라"));
        nationList.add(new Nation("영국","런던"));
        nationList.add(new Nation("프랑스","파리"));
    }

    private boolean contain(String country){
        for(int i=0; i<nationList.size();i++) {
            Nation nation = nationList.get(i);
            if(nation.getCountry().equals(country)){
                return true;
            }
        }
        return  false;
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
            if(contain(country)) {
                System.out.println(country+"는 이미 있습니다.");
                num--;
                continue; // 중복하는게 존재하면 건너뛰어라.
            }
            nationList.add(new Nation(country,capital));
            num++;
//            if(nationList.contains(country)){
//                System.out.println(country+"는 이미 있습니다.");
//            }else {
//                nationList.add(new Nation(country,capital));
//            }
        }
    }
    public void quiz(){
        while(true){
            //랜덤
//            Random random = new Random();
//            random.ints();
            int random=(int)(Math.random()*nationList.size());
            //나라이름뽑기
            Nation selectedNation = nationList.get(random);
            String question = selectedNation.getCountry();
            String answer = selectedNation.getCapital();
            System.out.println(question+"의 수도는??");
            String capital = scanner.next();
            if(capital.equals("그만")) {
                System.out.println("Quiz를 종료합니다.");
                break;
            }else if(capital.equals(answer)){
                System.out.println("정답입니다.");
            }else {
                System.out.println("오답입니다.");
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
                quiz();
            }else{
                System.out.println("잘못입력하셨습니다.");
            }
        }
    }
}

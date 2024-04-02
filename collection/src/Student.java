import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
    /*Student class id와 tel을 속성으로 가진다
    * map에 <String,student>로 장성호,new Student(1,"111-1111")
    * 5명을 map에 넣고  scanner통해 이름을 입력받아 id와 전화번호를 출력하시오
    * 이떄 찾는사람이 없으면 없는사람입니다 출력*/
    private String id;
    private String tel;

    public Student(String id, String tel) {
        this.id = id;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Student> telList = new HashMap<String,Student>();
        telList.put("유재석",new Student("dbwotjr","010-0000-0000"));
        telList.put("박명수",new Student("qkraudtn","010-1111-1111"));
        telList.put("정준하",new Student("wjdwnsgk","010-2222-2222"));
        telList.put("정형돈",new Student("wjdgudehs","010-3333-3333"));
        telList.put("노홍철",new Student("shghdcjf","010-4444-4444"));
        while(true){
            System.out.println("검색할 이름을 입력해 주세요 (종료입력시 프로그램을 종료합니다.)");
            String name = scanner.next();
            if(name.equals("종료")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if(telList.containsKey(name)) {
                System.out.println(name + "님의 ID는 "+telList.get(name).getId()+"전화번호는"+telList.get(name).getTel()+"입니다.");
            }else{
                System.out.println(name+"님은 전화번호부에 없습니다.");
            }
            /*telList.get(name)이 Student01을 리턴하므로 묶어서 표현할수도 있다.
            Student01 student = telList.get(name);
            if(student==null){
                System.out.println("없는 사람입니다.");
            }else {
                System.out.println(student.getId()+"=="+student.getTel());
            }*/
        }
    }
}

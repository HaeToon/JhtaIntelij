import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Scholarship {
    private String title;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String,Double>scoreMap= new HashMap<>();

    public Scholarship(String title) {
        this.title = title;

    }
    private void read(){
        System.out.println("장학금 관리 시스템입니다.이름과 학점을 입력해 주세요");
        for(int i=0; i<5; i++) {
            System.out.println("이름과 학점 >>");
            String name = scanner.next();
            double score = scanner.nextDouble();
            scoreMap.put(name,score);

        }
    }
    private void selectScholarship(){
        System.out.println("장학생 선발 기준을 입력해 주세요");
        double cutLine = scanner.nextDouble();
        System.out.println("장학생 명단");
        Set<String> keys = scoreMap.keySet();
        Iterator<String>iterator=keys.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            double score = scoreMap.get(name);
            if(score>cutLine) {
                System.out.println("장학생은"+name+"입니다.");
            }
        }
    }
    public void run(){
        read();
        selectScholarship();
    }
}

import java.util.*;

public class Quiz02 {
    //학생 5명의 이름과 점수를map에 저장하고
    //각학생의 이름과 점수를 뽑고 총점 및 평균을 구하시오
    public static void main(String[] args) {
        Map<String,Integer> students = new LinkedHashMap<String,Integer>();
        students.put("유재석",93);
        students.put("박명수",97);
        students.put("노홍철",72);
        students.put("정준하",78);
        students.put("정형돈",100);
        Set<String> keySet = students.keySet();
        Iterator<String>iterator = keySet.iterator();
        int sum =0;

        while(iterator.hasNext()) {
            String name = iterator.next();
            int score = students.get(name);
            sum+=score;
            System.out.println(name+"의 점수는"+score);
        }
        System.out.println("평균은 "+sum/students.size());
    }
}

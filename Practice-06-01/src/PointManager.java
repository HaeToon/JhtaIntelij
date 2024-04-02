import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PointManager {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int point;
    private Map<String, Integer> pointMap = new HashMap<>();

    void read() {
        System.out.println("포인트 추가 관리 프로그램입니다.");
        while (true) {
            System.out.println("이름과 포인트를 입력하시오.==>");
            String name = scanner.next();
            if (name.equals("그만")) break;
            int point = scanner.nextInt();
            // 기존포인트를 누적하기위한 기존포인트 선언 int 기초기때문에 는 null을못함. >wrapper로 변경 Integer null
            Integer originalPoint = pointMap.get(name);
            //포인트가 존재하면 + 없으면 입력하는 조건필요
            if (originalPoint != null) {
                point += originalPoint; // 입력받은 포인트에 기존포인트를 넣음
            }
            pointMap.put(name, point);
            showAll();
        }
    }
    public void showAll() {
        for (Map.Entry<String, Integer> entry : pointMap.entrySet()) {
            String name02 = entry.getKey();
            Integer point02 = entry.getValue();
            System.out.print("(" + name02 + "," + point02 + ")\t");
        }
    }

}




import java.util.Scanner;
public class Practice02 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("수학,과학,영어 순으로 점수를 입력해 주세요.");
        int math = scanner.nextInt();
        int science = scanner.nextInt();
        int english = scanner.nextInt();
        Grade grade = new Grade(math,science,english);
        System.out.println("세 과목의 평균은 "+grade.average(math,science,english)+"점 입니다.");
    }
}

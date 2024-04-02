import java.util.Scanner;
public class GradeTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("수학 과학 영어 점수를 순서대로 입력해 주세요");
        int math=scanner.nextInt();
        int science = scanner.nextInt();
        int english = scanner.nextInt();
        Grade me = new Grade(math,science, english);
        int avg=me.average();
        System.out.println("세 과목의 평균은 " + avg + "입니다.");
    }
}

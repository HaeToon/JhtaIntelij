import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) {
        System.out.println("달을 숫자로 입력하시오. >>");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        String season = null;
        if (month >= 3 && month <= 5) {
            season = "봄";
        } else if (month >= 6 && month <= 8) {
            season = "여름";
        } else if (month >= 9 && month <= 11) {
            season = "가을";
        } else if (month == 12 || month == 1 || month == 2) {
            season = "겨울";
        } else {
            System.out.println("잘못 입력했습니다.");
        }
        System.out.println("당신이 선택한 달은 " + season + "입니다.");
        System.out.printf("당신이 선택한 달은 %s 입니다.", season);
        // switch 의 case 에 정수, 문자(Char), 문자열 (String)

        switch (month) {
            case 3:
            case 4:
            case 5:
                season = "봄";
                break;
            case 6:
            case 7:
            case 8:
                season = "여름";
                break;
            case 9:
            case 10:
            case 11:
                season = "가을";
                break;
            case 12:
            case 1:
            case 2:
                season = "겨울";
                break;
            default:
                System.out.println("잘못 입력 했습니다.");
        }
        System.out.println("당신이 선택한 달은 " + season + "입니다.");
        System.out.printf("당신이 선택한 달은 %s 입니다.", season);
    }
}

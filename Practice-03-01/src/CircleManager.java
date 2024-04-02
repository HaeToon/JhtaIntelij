import java.util.Scanner;
public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //객체배열
        Circle arr[]=new Circle[3];
        for(int i=0; i<3; i++) {
            System.out.println("x,y,radius==>");
            double x =scanner.nextDouble();
            double y =scanner.nextDouble();
            int radius = scanner.nextInt();
            arr[i]=new Circle(x,y,radius);
        }
        for(Circle circle:arr) {
            circle.show();
        }
        //위아래 같은 내용
        for(int i=0;i<3;i++){
            arr[i].show();
        }
    }
}

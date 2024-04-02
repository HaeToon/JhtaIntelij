import java.util.Scanner;
public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle c[] = new Circle[3];
        double big=0;
        for(int i=0; i<c.length; i++) {
            double x=scanner.nextDouble();
            double y= scanner.nextDouble();
            int radious=scanner.nextInt();
            c[i]=new Circle(x,y,radious);
           if(big<c[i].big()){
               big=c[i].big();
           }
        }
        for(int i=0;i<c.length;i++) {
            c[i].showCircle();
        }
        System.out.println("가장 큰 면적의 원은"+big);
//        for(int i=0; i<c.length;i++) {
//            c[i].showCircle();
//        }

    }
}

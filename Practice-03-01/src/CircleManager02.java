import java.util.Scanner;

public class CircleManager02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int big=0;
        //객체배열
        Circle02 arr[]=new Circle02[3];
        for(int i=0; i<3; i++) {
            System.out.println("x,y,radius==>");
            double x =scanner.nextDouble();
            double y =scanner.nextDouble();
            int radius = scanner.nextInt();
            arr[i]=new Circle02(x,y,radius);
        }

        for(Circle02 circle:arr) {
            circle.show();
        }
        //for(Circle02 circle:arr)=for(int i=0;i<3;i++)
        //알고리즘
        for(int i=0;i<3;i++){
            double area = arr[i].getArea();
            if(arr[big].getArea()<arr[i].getArea()) {
                big=i;
            }
            arr[i].show();
            System.out.println();
        }
        System.out.println("가장 큰 면적의 원은");
        arr[big].show();
    }
}

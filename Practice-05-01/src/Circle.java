import java.sql.SQLOutput;

public class Circle {
    private int x,y,radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    //재정의
    @Override
    public boolean equals(Object obj) {
        Circle circle=(Circle)obj;
//        if(x==circle.x && y == circle.y){
//            return true;
//        }
//        return false;
        return x==circle.x && y == circle.y?true:false; //위와 같음
    }
    //재정의
    @Override
    public String toString() {
        return "Circle ("+x+","+y+") 반지름"+radius;
    }

    public static void main(String[] args) {
        Circle circle01 = new Circle(10,10,10);
        Circle circle02 = new Circle(10,10,50);
        System.out.println(circle01.toString());
        System.out.println(circle02.toString());
        if(circle01.equals(circle02)) {
            System.out.println("같은 원");
        }else {
            System.out.println("다른 원");
        }

    }
}

import java.util.Arrays;

public class Circle {
    private double x;
    private double y;
    private int radius;

    Circle(double x,double y,int radius) {
        this.x=x;
        this.y=y;
        this.radius=radius;
    }
    void showCircle() {
        System.out.println("x, y, radius >>" + x+" "+y+" "+radius);
        System.out.println("("+x+","+y+")"+radius);
    }
    double big() {
        return radius*radius*3.14;
    }
}


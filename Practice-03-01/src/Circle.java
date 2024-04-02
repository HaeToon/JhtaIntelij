public class Circle {
    private double x;
    private double y;
    private int radius;

    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void show(){
        System.out.printf("좌표 (%f,%f) 반지름 %d 인 원",x,y,radius);
        System.out.println("좌표 ("+x+","+y+")"+ " 반지름 "+radius+"인 원");
    }
}

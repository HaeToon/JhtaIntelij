public class Circle {
    private int x,y,radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    void show(){
        System.out.println("원 : Circle ("+x+","+y+") 반지름 "+radius);
    }

    @Override
    public boolean equals(Object obj) {
        Circle circle = (Circle)(obj);
        if(circle.x == x && circle.y==y) {
            return true;
        }
        return false;
    }
}

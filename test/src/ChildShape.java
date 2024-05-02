public class ChildShape extends Shape{
    public ChildShape(int x, int y) {
        super(x, y);
    }
    @Override
    public double area() {
        return x*y;
    }
    public static void main(String[] args) {
        ChildShape childShape = new ChildShape(10,10);
        System.out.println(childShape.area());
    }
}

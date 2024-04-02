public class CircleTest {
    public static void main(String[] args) {
        Circle circleA = new Circle(2,3,5);
        Circle circleB = new Circle(2,3,30);
        circleA.show();
        circleB.show();
        if(circleA.equals(circleB)) {
            System.out.println("같은원");
        }
    }
}

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override //toString() 을 재정의 [덮어쓰기 override]
    public String toString() {
        return "point(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj; // 다운캐스팅 obj(수퍼클래스)>obj(Point클래스)
        if (point.x == x && point.y == y) {
            return true;
        }
        return false;
    }
}

public class ObjectTest {

    //static heap 생성하지 않고도 미리 올려져 있는것.
    //static 을 클래스 변수 , 함수
    public static void showObj(Object object) {
        System.out.println(object.getClass().getName()); // 메서드를 이어서 쓰는것 = method chaining
        System.out.println(object.hashCode());
        System.out.println(object.hashCode());
        System.out.println(object.toString());
    }

    public static void main(String[] args) { // 접근지정자(public)생성자함수??(static)리턴타입(void)함수이름(main)
        //
        Point point = new Point(10, 20); // 생성자함수 호출시 heap memory 상에 올라감.
        showObj(point);
        Math.round(2.1); // Math는 미리 메모리에 올라가있는 상태 static에서 함수호출하려면 static이어야한다.

        //자바 메모리 구조 /static영역/ heap영역/ stack영역/
        //static (class 들이 여기에 올라감.static으로 선언된것들)
        //heap (new Point 같이 인스턴스 만들면 여기에 올라감.)
        //stack (Point p 인스턴스의 참조값이 여기에 저장됨.)
        // Point point(stack) = new Point(10,20)(heap)
        Point point02 = new Point(10, 20);
        Point point03 = point;

        System.out.println(point == point02); // 주소가 같은지 물어보는것. 값은 같더라도 주소는 다름.
        System.out.println(point == point03); // 같은 레퍼런스를 공유하기때문에 주소가 같음.
        System.out.println(point.equals(point02)); //equals를 재정의하여 point 의 좌표가 같으면 같게만듬.
        //기본 타입에서 == 은 값비교
        //레퍼런스 타입에서 == 은 주소비교
    }
}

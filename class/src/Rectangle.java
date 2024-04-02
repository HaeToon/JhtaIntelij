public class Rectangle {
    int width;
    int height;


    Rectangle() { //생성자 오버로드(여러개만드는것)

    }

    Rectangle(int w, int h) {
        //생성자 함수 타입이 없다 안쓰면 기본적으로 하나 생김.
        System.out.println("나는 넓이"+w+",높이"+h+"네모입니다.");
    }

    int getArea() {
        return width * height;
    }
}

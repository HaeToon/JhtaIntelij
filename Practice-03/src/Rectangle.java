public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    Rectangle(int x, int y,int width, int height) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    int square() {
        return width*height;
    }

    void showRectangle() {
        System.out.println("좌표 ("+x+","+y+") 에서 크기가" +width + " x " + height + "인 사각형");
    }
}

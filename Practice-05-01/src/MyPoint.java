public class MyPoint {
    private int x,y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
//재정의
    @Override
    public boolean equals(Object obj) {
        MyPoint p=(MyPoint)obj;
        if(x==p.x && y == p.y){
            return true;
        }
        return false;
    }
//재정의
    @Override
    public String toString() {
        return "Point ("+x+","+y+")";
    }

    public static void main(String[] args) {
        MyPoint myPoint01 = new MyPoint(10,20);
        MyPoint myPoint02 = new MyPoint(10,10);
        System.out.println(myPoint01.toString());
        if(myPoint01.equals(myPoint02)) {
            System.out.println("같은점");
        }else {
            System.out.println("다른점");
        }
    }
}

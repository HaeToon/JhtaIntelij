public class PositivePoint extends  Point{
    public PositivePoint(int x, int y) {
        super(x,y);
        if(x<0 || y<0) {
            super.move(0,0);
            super.move(0,0);
        }
    }
    @Override
    public void move(int x,int y){
        if(x>=0 && y>=0) {
            super.move(x,y);
        }else {
            return;
        }
    }
    public String toString (){ //toString 재정의
        return "("+getX()+","+getY()+")의 점 입니다.";
    }
    public static void main(String[] args) {
       PositivePoint positivePoint = new PositivePoint(-10,-10);
       positivePoint.move(-10,-10);
        System.out.println(positivePoint.toString());
    }
}

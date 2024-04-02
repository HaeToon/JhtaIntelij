public class Point3D extends Point {
    private int z;

    public int getZ() { // z는 private이므로 외부에서 사용하기위해 게터 지정 읽기전용 setter는 쓰기도가능
        return z;
    }
    Point3D(int x , int y , int z){
        super(x,y);
        this.z=z;
    }
    public void moveUp() {
        z++;
    }
    public void moveDown() {
        z--;
    }
    public void movez(int x,int y,int z){
        this.getX();
        this.getY();
        this.z=z;
    }
   public String toString (){ //toString 재정의
        return "("+getX()+","+getY()+","+z+")의 점 입니다.";
    }
    public static void main(String[] args) {
        Point3D point3D = new Point3D(1,2,3);
        System.out.println(point3D.toString());
        point3D.moveUp();
        System.out.println(point3D.toString());
        point3D.move(10,10);
        point3D.moveDown();
        System.out.println(point3D.toString());
        point3D.movez(100,200,300);
        System.out.println(point3D.toString());
    }
}

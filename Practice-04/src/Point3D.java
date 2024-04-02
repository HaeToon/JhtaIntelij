public class Point3D extends ColorPoint{
private int z;

    Point3D(int x, int y, String z) {
        super(x,y,z);
    }


    void moveUp() {

    }
   void moveDown() {

    }
    void move(int x, int y, int z) {

        this.z=z;
    }
}

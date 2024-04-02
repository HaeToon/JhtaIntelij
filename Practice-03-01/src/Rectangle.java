public class Rectangle {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //private int x,y,width,height;
   private int x;
   private int y;
   private int width;
   private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public int square(){
        return width*height;
    }

    public void show() {
        System.out.printf("좌표( %d , %d )에서 크기가 %d x %d인 사각형",x,y,width,height);
        System.out.println();
        System.out.println("좌표 ("+x+","+y+") 에서 크기가 " +width +" x "+height+ "인 사각형");
    }
    public boolean contains(Rectangle rect){
        if(rect.x > x &&
           rect.y > y &&
           rect.x+rect.width < x+width &&
           rect.y+rect.height < y+height
        ) {
            return true;
        }
        return false;
    }
}

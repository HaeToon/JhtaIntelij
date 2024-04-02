public class ColorPoint extends Point{
    private String color;
    ColorPoint(int x,int y,String color){
        super(x,y);
        this.color=color;
    }
    public ColorPoint(int x, int y) {
      super(x,y);
    }
    public ColorPoint() {
        super();
    }
    void setXY(int x, int y) {
      this.getX();
      this.getY();
    }
    void setColor(String color) {
        System.out.println(color+"색의"+"("+getX()+","+getY()+")");
    }

}
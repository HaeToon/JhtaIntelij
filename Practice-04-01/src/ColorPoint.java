public class ColorPoint extends Point{
    private String color;
        ColorPoint(int x , int y,String color){
            super(x,y);
            this.color=color;
        }
        public String toString(){ //부모(object)의 toString을 재정의
            return color+"색의 "+"("+this.getX()+","+this.getY()+")"+"의 점입니다.";
        }
        public void setXY(int x , int y){ //move자체가 setxy와 동일함.
            move(x,y);
        }
        public void setColor(String color){
            this.color=color;
    }
    //toString 메소드는 모든객체의 조상인 object가 가지고 있는메소드이다.
    //즉 모든 객체의 toString을 쓸수있다.
    public static void main(String[] args) {
        ColorPoint colorPoint = new ColorPoint(5,5,"red");
        System.out.println(colorPoint.toString());
        colorPoint.move(10,20);
        colorPoint.setColor("blue");
        System.out.println("새로 이동한 colorPoint는 "+colorPoint.toString());
    }
}

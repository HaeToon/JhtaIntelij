public class ColorPoint extends Point{
    private String color;
    //기본생성자는 내가따로 만들지 않아도 생성된다.
    //생성자가 하나라도 만들어지면 기본생성자는 만들어지지않는다.

    public ColorPoint(String color,int x, int y){

      super();
        this.color=color;
        System.out.println("나는colorpoint");
    }

    public ColorPoint(String color){
        super(100,100);
//        super();
        this.color=color;
        System.out.println("나는colorpoint");
    }
    void setColor(String color){
        this.color=color;
    }
    void showColorPoint(){
        System.out.println(color);
        this.showPoint();
    }

    public static void main(String[] args) {
        //colorPoint 는 stack에 생성
        ColorPoint colorPoint= new ColorPoint("blue"); //heap영역에 생성됨
        //casting upcasting일때는 자식 메서드는 사용불가하다.
        //생성자가 호출될때 부모 생성자도 호출된다.
        colorPoint.set(10,10);
        colorPoint.setColor("yellow");
        colorPoint.showColorPoint();//stack영역에 생성되고 쓰면 사라진다.
    }
}

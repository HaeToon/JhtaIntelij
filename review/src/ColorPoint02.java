import java.awt.*;

public class ColorPoint02 extends Point{
    private String color;
    //기본생성자는 내가따로 만들지 않아도 생성된다.
    //생성자가 하나라도 만들어지면 기본생성자는 만들어지지않는다.

    public ColorPoint02(String color, int x, int y){

      super();
        this.color=color;
        System.out.println("나는colorpoint");
    }

    public ColorPoint02(String color){
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
//        Point colorPoint= new ColorPoint02("blue"); //heap영역에 생성됨
       Point colorPoint = new ColorPoint02("blue",100,100);
        ColorPoint cp = (ColorPoint)colorPoint;
        cp.showColorPoint();
        //casting upcasting일때는 자식 메서드는 사용불가하다.
        //upcasting은 부모타입을 상속받는 모든것을 받을수 있다.
        //대신 부모타입의 메서드, 변수만 슬수있다.
        //만약 필요하면 다시 다운캐스팅해서 쓸수있다.
        //이때는 반드시 타입을 정해야하나

        //생성자가 호출될때 부모 생성자도 호출된다.
//        colorPoint.showColorPoint();//stack영역에 생성되고 쓰면 사라진다.
    }
}

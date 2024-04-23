
//설계상에서만 존재 추상메서드는 계층구조를 만들때 쓴다.
//설계와 구현의 분리 ...
abstract class Shape{
   abstract public void draw(); //abstract 추상메서드  추상메서드를 하나라도 갖는다면 클래스가 추상클래스가 되어야함.
}
class Line extends Shape {
    //재정의 Override 이름과 return type,매개변수가 같아야함. (덮어쓰기)
    public void draw (){
        System.out.println("Line");
    }
}
class Rect extends Shape {
    public void draw(){
        System.out.println("Rect");
    }
}
class Circle extends Shape{
    public void draw(){
        System.out.println("Circle");
    }
}
class Weapon{
    int fire(){
        return 1;
    }
}
class SuperWeapon extends Weapon{
    @Override
    int fire() {
        return 10;
    }
}
public class MethodOverrideTest {
    static void drawTest(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //Override는 동적 바인딩이 일어난다. Runtime 시 결정된다. (실행시점)
        Shape shape02 = new Line(); // 자식이 우선순위로 호출됨
        shape02.draw();
        drawTest(new Rect()); //실행시점에 Rect이므로 Shape의 자식인 Rect가 호출된다. (동적바인딩) <>Overload (정적바인딩)
        Shape shape01 = new Circle();
        shape01.draw();

        Weapon weapon;
        weapon = new Weapon();
        System.out.println(weapon.fire());
        weapon=new SuperWeapon();
        System.out.println(weapon.fire());

    }
}

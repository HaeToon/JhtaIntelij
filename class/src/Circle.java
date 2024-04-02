public class Circle {
    int radius;
    String name;
    //기본 생성자는 다른생성자를 정의하면 만들어지지않는다. 따라서 생성자함수를 만든다면 반드시 기본생성자를 정의해야한다.
    Circle() {
        radius=1;
        name="";
    }
    //생성자 함수명는 반드시 클래스명과 같아야함.
    Circle(int radius, String name) {
        System.out.println("나는" + radius + "의 반지름을 가진 " + name + "입니다.");
//    Circle(int _radius, String _name) {
       this.radius=radius;  //this는 클래스내에서 자기자신을 가리킴.
//       radius=_radius;
       this.name = name;
//       name = _name;
    }
    double getArea() { //클래스에 정의된 함수 메서드
        System.out.println(name+"의 넓이는 ");
      return radius*radius*3.14;
    }
}

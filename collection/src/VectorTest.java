import java.util.Vector;
public class VectorTest {
    public static void test(Vector<Integer>vector){ //Collection을 매개변수로도 사용가능함.
        for(int i=0; i<vector.size();i++) { //vector.size() = vector의 길이
            System.out.print(vector.get(i)+"\t");
        }
    }
    public static void test2(Vector<Point>vector){ //Collection을 매개변수로도 사용가능함.
        for(int i=0; i<vector.size();i++) { //vector.size() = vector의 길이
            System.out.print(vector.get(i)+"\t");
        }
    }
    public static void main(String[] args){
 //        Vector<Integer> vector = new Vector<Integer>();
           Vector<Integer> vector = new Vector<>();//타입추론 앞에Integer 를써서 뒤에것을생략가능 원래는써야함.

        //Vector는 길이가 없음. 가변적이다.
        vector.add(1);   //add () vector에 Integer타입의1을넣겠다.
        vector.add(10);
        vector.add(-1);
        vector.add(1,100); //원하는 index에 element를 넣을수있음.
        vector.set(0,1000); // vector0번을 1000으로 바꿈.
        //배열보다 Collection 을 많이 사용함.
        Vector<Point> vector02 = new Vector<Point>(); //Vector<>안에 뭘써야할지 모른다면 ?입력해도 됨.
        vector02.add(new Point(10,10)); //Point 는 referance(x,y)?이기때문에 new 해줘야함.
        vector02.add(new Point(10,20));
        vector02.add(new Point(10,30));
        vector02.remove(1); //vector02의 1번자리값을 지운다.
        test(vector);
        System.out.println();
        test2(vector02);
//        for(int i=0; i<vector02.size();i++) {
//            System.out.print(vector02.get(i)+"\t");
//        }
    }
}

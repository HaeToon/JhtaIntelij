import java.util.ArrayList;
import java.util.HashMap;

public class MyClassTest {
    public static void main(String[] args) {
        //컴파일할때 구체화된 타입을 대입한다.
        MyClass<String> myClass = new MyClass<String>();
        myClass.setValue("나는 문자열");
        System.out.println(myClass.getVal());

        MyClass<Integer> myClass02 = new MyClass<>();
        myClass02.setValue(100);
        System.out.println(myClass02.getVal());

        MyClass<Double>myClass03=new MyClass<>();
        myClass03.setValue(3.14);

        MyBox<String,Integer,Double> myBox = new MyBox<>("허태훈",1,3.14);
        System.out.println(myBox.getVal01());
        System.out.println(myBox.getVal02());
        System.out.println(myBox.getVal03());

        ArrayList<HashMap<String,String>>list = new ArrayList<>(); // generic의중첩선언
        HashMap<String,String>hashMap01 = new HashMap<>();
        hashMap01.put("ㅁㅁㅁ","ㅠㅠㅠ");
        list.add(hashMap01);
        list.get(0).get("허태훈");
        System.out.println(list.get(0).get("허태훈"));

        MyClassInteger myClassInteger02 = new MyClassInteger();
        MyClassDouble myClassDouble = new MyClassDouble(10.2);
        myClassInteger02.setVal(10);
        myClassDouble.getVal();
//        MyClassInteger myClassInteger = new MyClassInteger();
//        myClassInteger.setVal(100);
//        System.out.println(myClassInteger.getVal());
    }
}

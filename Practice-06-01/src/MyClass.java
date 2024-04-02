//Generic
//선언할때 일반화된 type을 추가  type은 컴파일할때 선언이됨. 타입을 매개변수처럼 받는것.
public class MyClass<T> {  //기호약속 <T> <다이아몬드 연산자> 타입을  먼저지정하지않겠다 Map<K,V>
    private T val;
    //private Object val;
    public T getVal() {
        return val;
    }

    public void setValue(T val) {
        this.val = val;
    }
}

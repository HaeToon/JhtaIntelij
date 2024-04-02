import java.util.Vector;

interface IStack<T> {
    T pop();
    boolean push(T ob);
}
public class MyStack<T> implements IStack<T> {
    Vector<T> vector = null;

    public MyStack() {
       vector = new Vector<>();
    }

    //Stack Lifo
    @Override
    public T pop() {
        return vector.remove(0); // 값을 삭제하고 삭제한것을 출력
    }

    @Override
    public boolean push(T ob) { // 0번에 넣으면 다른것들은 밀려남
        vector.add(0,ob);
        return true;
    }
}

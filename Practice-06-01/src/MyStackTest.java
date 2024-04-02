import java.util.Arrays;

public class MyStackTest {
    public static void main(String[] args) {
        IStack<Integer>stack=new MyStack<>();
       for(int i=0; i<10; i++) {
           stack.push(i);
       }
       for(int i=0;i<10;i++){
           System.out.print(stack.pop()+"\t");
       }
    }
}

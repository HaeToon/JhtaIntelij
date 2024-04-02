import java.util.Scanner;
import java.util.Vector;

public class VTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer>vector=new Vector<>();
        for(int i=0; i<10; i++) {
            int num = scanner.nextInt();
            vector.add(0,num);
        }
        for(int i=0; i<10; i++) {
            System.out.println(vector.remove(0));
        }
    }
}

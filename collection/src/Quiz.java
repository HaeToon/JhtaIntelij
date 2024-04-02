import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quiz {
    public static void main(String[] args){
        List<String> arrList = new ArrayList<String>();
        int big=0;
        arrList.add("자바");
        arrList.add("IntelliJ");
        arrList.add("html");
        arrList.add("자바스크립트");
        for(int i=0; i<arrList.size();i++) {
            if(arrList.get(big).length()<arrList.get(i).length()) {
                big=i;
            }
        }
        System.out.println("가장이름이 긴 것은 "+arrList.get(big));
        Iterator<String> iterator02 = arrList.iterator();
        while(iterator02.hasNext()) {
            System.out.print(iterator02.next()+"\t");
        }
        //List iterator
    }
}

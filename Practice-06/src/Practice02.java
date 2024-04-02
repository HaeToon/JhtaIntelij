import java.util.*;

public class Practice02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> ArrayList = new ArrayList<String>();
        System.out.println("6개의 학점을 빈칸으로 분리 입력");
       String grade = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(grade," ");
       while(st.hasMoreTokens()){
           ArrayList.add(st.nextToken());
       }
      Iterator<String> arr = ArrayList.iterator();
       int sum=0;
      for( int i=0; i<ArrayList.size(); i++) {
          if(ArrayList.get(i).equals("A")) {
              sum+=5.0;
          }else if (ArrayList.get(i).equals("B")){
              sum+=4.0;
          }else if (ArrayList.get(i).equals("C")){
              sum+=3.0;
          }else if (ArrayList.get(i).equals("D")){
              sum+=2.0;
          }else if (ArrayList.get(i).equals("E")){
              sum+=1.0;
          }else if (ArrayList.get(i).equals("F")){
              sum+=0;
          }else{
              System.out.println("잘못 입력하셨습니다.");
          }
      }
        System.out.println("학점의 평균은"+sum/ArrayList.size());
    }
}

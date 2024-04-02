public class Grade {
   private int math;
    private int science;
    private int english;

    Grade(int math,int science,int english) {
        this.math=math;
        this.science=science;
        this.english=english;
    }
    double average(int math,int science,int english) {
        return (math+science+english)/3.0;
    }


}

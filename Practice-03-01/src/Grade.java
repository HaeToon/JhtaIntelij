public class Grade {
    private int math; //private를 하지않으면 타 클래스에서 변수를 변경해버릴수 있음..
    private int science;
    private int english;

    public Grade(int math, int science, int english) {
        this.math = math;
        this.science = science;
        this.english = english;
    }
    public int average() {
        int result = (math+science+english)/3;
        return result; //return (math+science+english)/3;
    }
}

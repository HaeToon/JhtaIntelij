public class MethodOverlord {
    //오버로드(여러개 만드는것) !== 오버라이드 (부모가 만든것을 재정의하는것)
    int getSum(int i, int j) {
        return i+j;
    }
    double getSum(double i, double j) {
        return i+j;
    }
    // 오버로드는 이름은 같아야하고 매개변수가 다르거나 매개변수가 같으면 매개변수타입이 달라야함.
    int getSum(int i ,int j,int k) {
        return i+j+k;
    }
    int getSum(double i ,double j , int k) {
        return (int)(i+j+k);
    }
    public static void main(String[] args) {
        MethodOverlord methodOverlord = new MethodOverlord();
        int result01 = methodOverlord.getSum(10,20);
        double result02 = methodOverlord.getSum(10.2 , 10.5);
        System.out.println(result01 + "===" + result02);
    }
}

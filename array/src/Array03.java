public class Array03 {
    enum Day {sun, mon, tue, wed, thu, fri, sat}
    // enum 열거형 비슷한것들을 나열할때.
    enum User {admin, user, manager}

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        String animals[] = {"dog", "cat", "tiger", "lion", "rabbit"};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
        for (int el : nums) {
            System.out.print(el + "\t");  //위아래 같은 내용
        }
        System.out.println();
        for (String animal : animals) {
            System.out.print(animal + "\t");
        }
        System.out.println(); //values = 배열을 리턴해줌
        for (Day day : Day.values()) {
            System.out.print(day + "\t");
        }
        int intArr[][]= new int [3][2];
        intArr[0][0]=10;
        intArr[0][1]=20;
        intArr[1][0]=30;
        intArr[1][1]=40;
        intArr[2][0]=50;
        intArr[2][1]=60;
        //[[10,20][30,40][50,60]]
        int intArr02[][] = {{10,20},{30,40},{50,60}}; // =  int intArr[][]= new int [3][2]; 행과 열
    }
}

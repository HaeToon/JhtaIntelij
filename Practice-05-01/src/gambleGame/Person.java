package gambleGame;

import java.util.Scanner;

public class Person {
    //1.scanner
    //2.이름출력
    //3.난수 생성하는  메서드
    //4.난수3개를 뽑는 메서드
    private String name;
    private Scanner scanner = new Scanner(System.in);
    public Person(String name) { //생성자
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean turn(){ //난수3개 만들고 3개가 일치하면 이기는것으로 만들기
        System.out.print("["+name+"] : Enter");
        scanner.nextLine(); //엔터입력
        int nums[] = new int[3];
        for(int i=0; i<nums.length; i++) {
            nums[i]=(int)(Math.random()*3+1);
            System.out.print(nums[i]+"\t"); // \t =탭
        }
        boolean result = true;
        for(int i=0; i<nums.length;i++) {
            if(nums[0]!=nums[i]) {
                result=false;
                break;
            }
        }
//        if(result) {
//            System.out.println("이겼습니다.");
//        }else {
//            System.out.println("안타깝습니다.");
//        }
        return result;
    }
}

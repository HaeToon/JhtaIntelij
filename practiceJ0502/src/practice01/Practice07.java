package practice01;

import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("1~12사이의 수를 입력해주세요");
        int num = sc.nextInt();
        boolean isOk=false;
        String season="계절";
        if(num>2 && num<6) {
            season = "봄";
            isOk=true;
        }else if(num>5 && num<9){
            season = "여름";
            isOk=true;
        }else if(num>8 && num<12){
            season="가을";
            isOk=true;
        }else if(num==12 || num>0 && num<3){
            season="겨울";
            isOk=true;
        }else {
            System.out.println("잘못입력하셨습니다.");
            isOk=false;
        }
        if(isOk) {
            System.out.println(num + "월은" + season + "입니다.");
        }
    }
}

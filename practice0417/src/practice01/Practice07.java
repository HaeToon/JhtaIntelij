package practice01;

import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("1~12사이의 정수를 입력해주세요,");
        int num = sc.nextInt();
        String season = "season";
        if(num>2 && num<6){
            season="spring";
        }else if(num>5 && num<9){
            season="summer";
        }else if(num>8 && num<12){
            season="fall";
        }else if(num==12 ||num>0 && num<3){
            season="winter";
        }
        System.out.println(num +"==="+season);
    }
}

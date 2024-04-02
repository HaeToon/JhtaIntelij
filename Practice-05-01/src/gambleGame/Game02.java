package gambleGame;

import java.util.Scanner;

public class Game02 { //5-12번
    private Person playerList[];
    private Scanner scanner = new Scanner(System.in);
private int numOfPlayer;
    public Game02() {
        System.out.println("게임에 참여할 플레이어수를 입력해 주세요.");
        numOfPlayer= scanner.nextInt();
        scanner.nextLine();
        playerList = new Person[numOfPlayer];
        for(int i=0; i<playerList.length; i++) {
            System.out.println((i+1)+"번째 선수 입력");
            String name = scanner.next();
            playerList[i]= new Person(name);
        }
    }
    void run(){
        //플레이어가 번갈아가면서 플레이
        int i = 0;
        while(true){
            if(playerList[i].turn()){
                System.out.println(playerList[i].getName()+"님이 이겼습니다.");
                break;
            } else {
                i=++i%playerList.length;
                System.out.println("안타깝네요.");
            }
        }
    }
}
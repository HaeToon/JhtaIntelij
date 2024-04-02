package gambleGame;

import java.util.Scanner;

public class Game {//5-10번
    private Person playerList[] = new Person[2];
    private Scanner scanner = new Scanner(System.in);

    public Game() {
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

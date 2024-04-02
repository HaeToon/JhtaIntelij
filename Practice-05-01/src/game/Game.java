package game;

public class Game {
   private final String hand[] = {"가위", "바위", "보"}; //final 입력시 바꿀수없음.
    private Player player ;
    private Computer computer ;

    public Game() {
        player = new Player("철수");
        computer= new Computer("컴퓨터");
    }
    public void run() {
        while (true) {
            int computerChoice = computer.turn(); // 1,2,3
            int playerChoice = player.turn();
            if (playerChoice == 4) {
                System.out.println("종료합니다.");
                break;
            }
            if (playerChoice < 1 || playerChoice > 4) {
                System.out.println("잘못 입력 하셨습니다.");

            } else {
                System.out.print(player.getName() + "님이 낸것 (" + hand[playerChoice - 1] + ") ===");
                System.out.println(computer.getName() + "님이 낸것 (" + hand[computerChoice - 1] + ")");
                if (playerChoice == computerChoice) {
                    System.out.println("비겼습니다.");
                } else if (playerChoice == 1 && computerChoice == 3 ||
                        playerChoice == 2 && computerChoice == 1 ||
                        playerChoice == 3 && computerChoice == 2) {
                    System.out.println(player.getName() + "님이 이겼습니다.");
                } else {
                    System.out.println(computer.getName() + "님이 이겼습니다.");
                }
            }
        }
    }
    //game안에 메인을 만들면 아래처럼
//    public static void main(String[] args) {
//        Game game = new Game();
//        game.run();
//        System.out.println(playerChoice + "===" + computerChoice);
//        String hand[] = {"가위", "바위", "보"};
//        Player player = new Player("철수");
//        Computer computer = new Computer("인공지능");
//        while (true) {
//            int computerChoice = computer.turn(); // 1,2,3
//            int playerChoice = player.turn();
//            if (playerChoice == 4) {
//                System.out.println("종료합니다.");
//                break;
//            }
//            if (playerChoice < 1 || playerChoice > 4) {
//                System.out.println("잘못 입력 하셨습니다.");
//
//            } else {
//                System.out.print(player.getName()+"님이 낸것 ("+hand[playerChoice-1]+") ===");
//                System.out.println(computer.getName()+"님이 낸것 ("+hand[computerChoice-1]+")");
//                if(playerChoice==computerChoice) {
//                    System.out.println("비겼습니다.");
//                }else if(playerChoice==1 && computerChoice==3 ||
//                        playerChoice==2 && computerChoice==1 ||
//                        playerChoice==3 && computerChoice==2) {
//                    System.out.println(player.getName()+"님이 이겼습니다.");
//                }else {
//                    System.out.println(computer.getName()+"님이 이겼습니다.");
//                }
//            }
//        }
    }
//}

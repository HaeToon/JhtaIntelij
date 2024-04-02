import java.util.Scanner;
public class PhoneBook {
    private Scanner scanner = null;
    private Phone phoneList[]=null;

    public PhoneBook() {
        scanner = new Scanner(System.in);
    }
        private void save() {
            System.out.println("저장할 수를 입력해주세요.");
            int num = scanner.nextInt();
            phoneList = new Phone[num];
            for (int i = 0; i < num; i++) {
                System.out.println((i + 1) + "번째 이름을 입력해주세요(빈칸없이 입력");
                String name = scanner.next();
                System.out.println(name + "님의 전화번호를 입력해주세요(빈칸없이 입력");
                String tel = scanner.next();
                phoneList[i] = new Phone(name, tel);
            }
            System.out.println("전화번호 " + num + "개가 저장되었습니다.");
        }
        private void search(String name) {
            boolean isSerch = false;
            for(int i=0; i<phoneList.length;i++) {
                if (phoneList[i].getName().equals(name)) {
                    System.out.println(name + "님의 전화번호는 " +phoneList[i].getTel() + " 입니다.");
                    isSerch=true;
                }
            }
            if(isSerch==false) {
                System.out.println(name + "님은 전화번호부에 없습니다.");
            }
        }
    public void run() {
        save();
        while(true) {
            System.out.println("검색할 이름을 입력하세요(종료 입력시 프로그램을 종료합니다.)");
            String name = scanner.next();
            if(name.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            }
                search(name);
        }
    }
}

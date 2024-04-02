import java.io.File;

public class FileTest {
    public static void main(String[] args){
        //컴퓨터에서 가장 작은단위 file ?.. bit아닌가
        //file들을 folder로 묶음
        //file 을 다룰수있는 class File이있다.
        //내가 찍은게 file 인지 folder인지 알수도있고 만들수도있다.

        File file = new File("C:\\Windows\\system.ini");
        System.out.println(file.isFile()); // file인지 아닌지
        System.out.println(file.getPath()); //file의 경로
        System.out.println(file.getName()); //file의 이름,확장파일명
        String fileName = file.getName();
        String arr [] = fileName.split("\\."); // .은 \\.으로 써야 쪼개짐.
        System.out.println(arr[1]); // file의 확장파일명이 나옴.
        System.out.println(file.length() + "byte"); //파일의 크기

        File dir = new File("C:\\Windows");
        File dir02 = new File("C:\\Users\\jhta\\Desktop\\myFolder");


        File subFiles[]=dir.listFiles(); // dir의 파일들을 subfiles 배열에 넣음
        System.out.println(dir02.exists());
        for(int i=0; i<subFiles.length; i++) { //subfiles 배열의 모든것 출력
            File file02 = subFiles[i];
            System.out.println(file02.getName());
        }
        if(!dir02.exists()){   // dir02가 존재하지않으면 조건실행
            dir02.mkdir();      //dir02를 만들어라. mkdir = make directory
        }

        System.out.println(dir.isFile()); // folder 는 파일이 아님.

        System.out.println(dir.length());
    }
}

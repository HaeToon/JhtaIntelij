import java.io.File;

public class Practice08 {
    public static void main(String[] args){
        File file = new File("C:\\"); // File 은 file 이될수도있고 folder가 될수도있다.
        File files[] = file.listFiles();
        long big=0;
        File biggestFile = null;
        for(int i=0; i<files.length; i++){
            File temp = files[i]; //폴더는 크기가 없다.
            if(!temp.isFile()){
                continue; // file이 아니면 건너뛰기
            }
//            System.out.println(temp.getName() + "==="+temp.length());
            long fileSize = temp.length();
            if(big<fileSize){
                big=fileSize;
                biggestFile = temp;
            }
        }
        System.out.println("가장 큰 파일은" + biggestFile.getName()+"크기는"+ biggestFile.length()/(1024*1024) + "mb");
    }
}

import java.io.File;

public class Practice09 {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\jhta\\Desktop\\Temp");
        File files[] = dir.listFiles(); // dir의 파일들을 files배열에 넣기
        int count=0;
        for(int i=0; i<files.length; i++){
            File temp = files[i];
            if(!temp.isFile()){
                continue; // file이 아니면 건너뛰기
            }
            String fileName = temp.getName();
//            fileName.endsWith(".txt"); // endWith ()안의 내용으로 끝나는것 찾기
            int idx= fileName.lastIndexOf(".");
            System.out.println(idx);
            String extention = fileName.substring(idx);
//            if(extention.equals(".txt")){ //아래와 같은내용
//                temp.delete();
//                count++;
//            }
            if(fileName.endsWith(".txt")){
                temp.delete();
                count++;
            }
        }
        System.out.println(count + "개의 txt 파일이 삭제되었습니다.");
    }
}

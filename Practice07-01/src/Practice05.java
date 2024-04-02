import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Practice05 {
    private static boolean compare(FileInputStream fileInputStream01, FileInputStream fileInputStream02) {
        byte buffer01[] = new byte[1024]; //1kb 씩 비교
        byte buffer02[] = new byte[1024];
        int count01, count02;
        while (true) {
            try {
                count01 = fileInputStream01.read(buffer01, 0, buffer01.length);
                count02 = fileInputStream02.read(buffer02, 0, buffer02.length);
//                System.out.print(count01);
//                for(int i=0; i<count01; i++){ //출력용
                //                    System.out.print(buffer01[i]+"/"+buffer02[i]+"|");
//                }
                if (count01 != count02) { // 파일의 길이비교
                    return false;
                }
                if (count01 == -1) break;
                for (int i = 0; i < count01; i++) {  // 파일의 내용비교
                    if(buffer01[i]!=buffer02[i]){
                        return false;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //반복문 돌려서 byte 단위로 비교해서 하나라도다르면 flase 리턴
        try {
//            FileInputStream fileInputStream01 = new FileInputStream("C:\\Users\\jhta\\Desktop\\myFolder\\elvis01.txt");
            FileInputStream fileInputStream01 = new FileInputStream("C:\\Users\\jhta\\Desktop\\ham.jpg");
//            FileInputStream fileInputStream02 = new FileInputStream("C:\\Users\\jhta\\Desktop\\myFolder\\elvis02.txt");
            FileInputStream fileInputStream02 = new FileInputStream("C:\\Users\\jhta\\Desktop\\myFolder\\ham.jpg");
            compare(fileInputStream01, fileInputStream02);
            if (compare(fileInputStream01, fileInputStream02)) {
                 System.out.println("같다");
            } else {
                  System.out.println("다르다");
            }
            fileInputStream02.close();
            fileInputStream01.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

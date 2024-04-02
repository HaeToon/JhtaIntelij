import java.io.*;
//Ansi 파일을 읽을때 ms949
public class FileReaderKor {
    //Reader /Writer 는 문자데이터를 읽고 쓰겠다는 의미.
    public static void main(String[] args) {
        //자바에서 입출력 관련된것들은 전부다 try catch 해야함.
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;  //보조스트림  (fileInputSteam) 매개변수로 스트림을 받아서 처리할수 있다.

        try {
            fileInputStream = new FileInputStream("C:\\Users\\jhta\\Desktop\\sampleKor.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"MS949");
            int c;
            while((c= inputStreamReader.read())!=-1){
                System.out.print((char)c);
            }
            //닫을때는 역순으로 닫는다.
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try { //시도했을때 없다면 catch 함.
//            //FileReader fileReader =new FileReader("C:\\Users\\jhta\\Desktop\\sampleKor.txt");
//
//
//            //출력
//            // 읽을때는 글자하나하나를 int로 읽음
//            int c;
//            // eof end of file 은 마지막에 return 을 -1 을 리턴함.
//            while ((c = fileReader.read()) != -1) {
//                System.out.print((char) c);
//            }
//        } catch (FileNotFoundException e) {
////            throw new RuntimeException(e);
//            System.out.println("정해진 경로에 파일이 없습니다.");
//        } catch (IOException e) {
////            throw new RuntimeException(e);
//            System.out.println("파일 읽기를 실패했습니다.");
//        }
    }
}

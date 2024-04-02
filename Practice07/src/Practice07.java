import java.io.*;

public class Practice07 {
    public static void main(String[] args) {
        File originalImg = new File("C:\\Users\\jhta\\Desktop\\myFolder\\a.jpeg");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolderCopy\\a.jpeg");
        originalImg.length();
        copy.length();
        int c;
        int count =0;
        try {
            FileInputStream fileInputStream = new FileInputStream(originalImg);
            FileOutputStream fileOutputStream = new FileOutputStream(copy);
            System.out.println(originalImg.length());
            System.out.println(copy.length());
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write((byte) c);
                System.out.println((byte) c);
                if(count==879394/10){
                    System.out.print("*");
                    count=0;
                }
                count++;
            }
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

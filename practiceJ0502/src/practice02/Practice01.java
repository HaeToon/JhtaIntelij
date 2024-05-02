package practice02;

public class Practice01 {
    public static void main(String[] args){
        int sum01=0;
        int sum02=0;

        for(int i=0; i<100; i+=2){
            sum01+=i;
        }
        System.out.println(sum01);
        int i=0;
        while(i<100){
            sum02+=i;
            i+=2;
        }
        System.out.println(sum02);
    }
}

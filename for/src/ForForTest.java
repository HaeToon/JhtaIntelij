public class ForForTest {
    public static void main(String[] args) {
        //구구단
       /* for (int i = 1; i <=9; i++) {
            System.out.println();
            for (int j = 1; j<=9; j++) {
                System.out.print(j + " x " + i + " = " + i*j);
                System.out.print("\t");
            }
        }
        */
        int i = 1;
        //continue , break
//        int j = 0;
//        while(i <9) {
//        int j = 0;
//            i++;
//            System.out.println();
//            while (j<9) {
//                j++;
//                System.out.print(j + " x " + i + " = " + i*j);
//                System.out.print("\t");
//
//            }
//
//            System.out.print(j + " x " + i + " = " + i*j);
//            System.out.print("\t");
//        }
        while (i<=9) {
            System.out.println();
            int j = 1;
            while (j<=9) {
                System.out.print(j + " x " + i + " = " + i*j);
                System.out.print("\t");
                j++;
                if (i==5) continue;
            }
            i++;
        }
    }
}

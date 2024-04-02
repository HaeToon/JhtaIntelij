public class ArrayQuiz02 {
    public static void main(String[] args) {
        // 졸업학점
        // 1-1 1-2 2-1 2-2 3-1 3-2

        double score[][] = {{2.5, 2.8}, {3.2, 3.5}, {3.7, 4.1}, {4.2, 4.3}};
        double sum = 0;
        for (int year = 0; year < score.length; year++) {
            for (int term = 0; term < score[year].length; term++) {
                sum += score[year][term];
            }
        }
        double result = (int)(sum / 8*100)/100.0; // 인트를 인트로 나누면 소숫점단위를 다지워버림
        System.out.println(result);
        // 자바 배열 ArrayList
        // 소수점 둘째자리 까지만
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle basketBall = new Circle(20,"농구공");
        Circle baseBall = new Circle(12,"야구공");


        System.out.println(basketBall.getArea());
        System.out.println(baseBall.getArea());
        Rectangle rectangle = new Rectangle(20,21);
        rectangle.width = 10;
        rectangle.height = 10;
        System.out.println(rectangle.getArea());

        Book chunhyang = new Book("춘향전");
        System.out.println(chunhyang.title + "==" + chunhyang.author);
        Book hong = new Book("홍길동전","허균");
        System.out.println(hong.title +"==" + hong.author);

        Book littlePrince = chunhyang;
        littlePrince.author = "생텍쥐 베리";
        System.out.println(littlePrince.title);
        System.out.println(littlePrince.author);
        System.out.println(chunhyang.author); // 객체는 모두 레퍼런스 타입이라 주소를 공유함. 따라서 "작자미상"에서 바뀜.

        Circle arr[]= new Circle[3]; //객체도 배열에 넣어짐.
        String nameList[] = {"농구공","배구공","야구공"};
        for(int i=0;i<3; i++) {
            arr[i] = new Circle((int)(Math.random()*20+5),nameList[i]);
        }
        System.out.println(arr[0].name+"=="+arr[0].radius);
        System.out.println(arr[1].name+"=="+arr[1].radius);
        System.out.println(arr[2].name+"=="+arr[2].radius);

    }
}

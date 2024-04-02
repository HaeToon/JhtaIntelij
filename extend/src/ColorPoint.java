public class ColorPoint extends Point {
    private String color;
    public void setColor(String color){
        this.color=color;
    }
    public void show() {
        System.out.printf("색깔은 %s",color);
        super.show(); //show() = recursive 재귀함수 자기가 자기를 호출하는함수 함수이름을 바꾸던지 .super을 붙여 부모의 show를 호출
                        //재귀함수 실행시 stackOverFlow에러 발생
    }
}

public class Rect {
   private int width,height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        Rect rect = (Rect)obj;
        if(rect.width*rect.height == width*height) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Rect rect01 = new Rect(10,20);
        Rect rect02 = new Rect(8,25);
        Rect rect03 = rect01;
        System.out.println(rect01==rect02); //주소값 비교이므로 false
        System.out.println(rect01==rect03); //주소값 비교이므로 true
        System.out.println(rect01.equals(rect02));//equals를 재정의하여 값이같으면 true로  원래는 값이같아도주소가 다르므로 false.
    }
}

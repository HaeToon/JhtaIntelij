public class Song {
    private String title;
    private String artist;
    private int year;
    private String country;


    public Song() { // 빈 기본 생성자

    }
    Song(int year,String country,String artist,String title){ //매개변수로 모든 필드를 초기화하는 생성자
        this.year=year;
        this.country=country;
        this.artist=artist;
        this.title=title;
    }


    public void show(){ //void 가 아닌 다른것을 쓰면 반드시 리턴해야함.
        System.out.println(year+"년, "+country+" 국적의 "+artist+"가 부른 "+title);
        System.out.printf("%d년, %s 국적의 %s가 부른 %s",year,country,artist,title);
    }

}

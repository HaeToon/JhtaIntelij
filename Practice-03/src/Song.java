public class Song {
    private String title;
    private String artist;
    private int songYear;
    private String country;

    Song(int songYear, String country, String artist, String title) {
        this.songYear = songYear;
        this.country = country;
        this.artist = artist;
        this.title = title;
    }
    public void songShow(){System.out.println(songYear+"년, "+country + " 출신의 "+artist + "가 부른 " +title);}
}

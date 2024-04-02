public class TV {
    private String brand;
    private int size;
    private int tvYear;

    TV(String brand, int year, int size) {
        this.brand = brand;
        this.tvYear = year;
        this.size = size;

    }
    public void showTv() {
        System.out.println(brand+"에서 만든"+tvYear + "년" + size+"인치 TV");
    }
}

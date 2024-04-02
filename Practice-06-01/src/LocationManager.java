import java.util.*;

public class LocationManager {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Location> cities = new HashMap<String, Location>();

    private void read() {
        System.out.println("도시정보를 입력해 주세요.[도시,위도,경도]");
        for (int i = 0; i < 4; i++) {
            System.out.println("입력시작>>");
            String str = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(str, ",");
            String city = st.nextToken();
            double longitutde = Double.parseDouble(st.nextToken());
            double latitude = Double.parseDouble(st.nextToken());// Double.parseInt(문자열) 문자열을 double로바꿈
            Location location = new Location(city, longitutde, latitude);
            cities.put(city, location);
        }
    }

    public void showAll() {
        for (String key : cities.keySet()) { //for each 반복문
            Location location = cities.get(key);
            String city = location.getCity();
            double longitutde = location.getLongitude();
            double latitude = location.getLatitude();
            System.out.println("--------------------------------------------");
            System.out.printf("도시 : %s 위도 : %.4f  경도 : %.4f ", city, longitutde, latitude);
            System.out.println();
        }
//        for(Map.Entry<String,Location>entry:cities.entrySet()){ //Entry 반복문 Map.Entry<Key,Value>
//            String key = entry.getKey();
//            Location location = entry.getValue();
//            String city = location.getCity();
//            double longitutde = location.getLongitude();
//            double latitude = location.getLatitude();
//            System.out.println("--------------------------------------------");
//            System.out.printf("도시 : %s 위도 : %.4f  경도 : %.4f ", city, longitutde, latitude);
//            System.out.println();
//        }

    }

    public void query() {
        while (true) {
            System.out.println("검색할 도시이름을 입력해주세요");
            String selectedCity = scanner.nextLine();
            if (selectedCity.equals("그만")) break;
            Location location = cities.get(selectedCity);
//            boolean isSearch = false;
//            for (int i = 0; i < students.size(); i++) {
            if (location != null) {
//                    isSearch = true;
                String city = location.getCity();
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();
                ;
                System.out.printf("도시 : %s 위도 : %.4f  경도 : %.4f", city, longitude, latitude);
                System.out.println();
            } else {
                System.out.println(selectedCity + "은 없습니다.");
            }
//            }
//            if (isSearch == false) {
//                System.out.println(name + "은 없습니다.");
//            }
        }
    }

    public void run() {
        read();
        showAll();
        query();
    }
}

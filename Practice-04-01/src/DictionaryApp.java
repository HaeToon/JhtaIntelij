import java.util.Arrays;

public class DictionaryApp {
    public static void main(String[] arsg) {
        Dictionary dictionary = new Dictionary(10);
        dictionary.put("황기태", "자바");
        dictionary.put("이재문", "파이선");
        dictionary.put("장성호", "오라클");
        dictionary.put("이재문", "C++"); // 이재문의 값을 C++로 수정
        System.out.println("길이==="+dictionary.length());
        System.out.println("이재문의 값은 " + dictionary.get("이재문")); // 이재문 아이템 출력
        System.out.println("황기태의 값은 " + dictionary.get("황기태")); // 황기태 아이템 출력
        System.out.println("장성호의 값은 " + dictionary.get("장성호")); // 황기태 아이템 출력
        dictionary.delete("황기태"); // 황기태 아이템 삭제
        System.out.println("이재문 값은 " + dictionary.get("이재문")); // 삭제된 아이템 접근
        System.out.println(dictionary.length());
        System.out.println(Arrays.toString(dictionary.keyArray));
        System.out.println(Arrays.toString(dictionary.valueArray));
    }
}

package programmers.level2.전화번호목록;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        String[] phone_book = {"12","123","1235","567","88"};

        boolean solution = solution(phone_book);

        System.out.println("solution = " + solution);

    }

    /**
     * 처음 코드는[key-value]를 [길이-크롭한문자열]로 설정.
     * 이 코드는 value가 list로 들어가면서 배열 사용이 많을 수 밖에 없었다.
     * (모든 값 list를 순회해야되기 때문에)
     * */
    /*public static boolean solution(String[] phone_book) {
        // 길이, 번호문자열
        Map<Integer, List<String>> phoneMap = new HashMap<>();

        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                String cropPhone = phone.substring(0, i);
                List<String> cropPhoneList = phoneMap.containsKey(cropPhone.length()) ? phoneMap.get(cropPhone.length()) : new ArrayList<>();

                if (cropPhoneList.contains(phone)) {
                    return false;
                }

                cropPhoneList.add(cropPhone);
                phoneMap.put(cropPhone.length(), cropPhoneList);
            }
//            System.out.println("     phoneMap = " + phoneMap);
        }

        return true;
    }*/


    /**
     *[프로그래머스/해시/level2] 전화번호목록
     * 애초에 폰을 key로 잡으면 조회 속도과 엄청나게 빨라진다.
     * phone_book 을 key 로 잡은 hashMap 의 키를 순회하며, 각 키별로 1개씩 크롭하여 포함하고 있는지 확인하도록 수정했다.
     * 코드가 훨씬 단순해졌다.
     *
     * 매번 key-value 구조를 떠올릴 때, value에 대단한 값이 들어가야만 할 것 같은 사고에 빠진다.
     * List 구조 시 순회 속도가 현저히 떨어질 수 밖에 없는 조건에는 Map의 Key로 설정함으로써 조회속도를 향상시킬 수 있음을 명심해야겠다.
     *
     * */
    public static boolean solution(String[] phone_book) {
        // 크롭한 문자열, 0
        Map<String, Integer> phoneMap = new HashMap<>();

        for (String phone : phone_book) {
            phoneMap.put(phone, 0);
        }

        for (String key : phoneMap.keySet()) {
            for (int i = 1; i <= key.length() - 1; i++) {
                String cropPhone = key.substring(0, i);
                if (phoneMap.containsKey(cropPhone)) {
                    return false;
                }
            }
        }

        return true;
    }
}

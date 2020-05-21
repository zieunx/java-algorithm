package beakjoon;

import java.util.HashMap;
import java.util.Map;

public class n1011_2 {
    public static void main(String[] args) {
        int X = 1;
        int Y = 5 - 1;

        Map<String, Integer> params = settingMap(3, 2, 3, 1, 4);
        params.put("N", X);

        Map<String, Integer> xGroup = getGroup(params);
        xGroup.put("N", Y);
        System.out.println(xGroup.toString());

        Map<String, Integer> yGroup = getGroup(xGroup);
        System.out.println(yGroup.toString());
//
//        System.out.println("xGroup = " + xGroup.get("group"));
//        System.out.println("yGroup = " + yGroup.get("group"));
        System.out.println("result = " + ((yGroup.get("group") - xGroup.get("group")) + 1));
    }
    static Map<String, Integer> getGroup (Map<String, Integer> params) {
        int N = params.get("N");
        int group = params.get("group");
        if (N == 0) {
            return settingMap(1, 0, 0, 1, 1);
        } else if (N == 1) {
            return settingMap(2, 1, 1, 1, 2);
        }
        /* X그룹 구하기 관련 변수 */
        int startNumber = params.get("startNumber");
        int endNumber = params.get("endNumber");
        int startPlus = params.get("startPlus");
        int endPlus = params.get("endPlus");


        boolean finish = false;

        while (!finish) {
            startNumber = startNumber + startPlus;
            endNumber = endNumber + endPlus;
            startPlus = startNumber-1;
            endPlus = endPlus * 2;
            if (startNumber <= N && N <= endNumber) {
                finish = true;
            }
            group ++;
        }
        return settingMap(group, startNumber, endNumber, startPlus, endPlus);
    }

    static Map<String, Integer> settingMap (int group, int startNumber, int endNumber, int startPlus, int endPlus) {
        Map<String, Integer> map = new HashMap<>();

        map.put("group", group);
        map.put("startNumber", startNumber);
        map.put("endNumber", endNumber);
        map.put("startPlus", startPlus);
        map.put("endPlus", endPlus);

        return map;
    }
}

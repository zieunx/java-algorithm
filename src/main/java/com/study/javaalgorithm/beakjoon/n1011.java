package com.study.javaalgorithm.beakjoon;

import java.util.HashMap;
import java.util.Map;

public class n1011 {
    public static void main(String[] args) {
        int X = 14;
        int Y = 16;

        Map<String, Integer> params = settingMap(3, 2, 3, 1, 2);
        params.put("N", X);

        Map<String, Integer> xGroup = getGroup(params);
        xGroup.put("N", Y);
        Map<String, Integer> yGroup = getGroup(xGroup);

        System.out.println("xGroup = " + xGroup.get("group"));
        System.out.println("yGroup = " + yGroup.get("group"));
        System.out.println("result = " + (yGroup.get("group") - xGroup.get("group")));
    }
    static Map<String, Integer> getGroup (Map<String, Integer> params) {
        int N = params.get("N");
//        if (N == 0) {
//            return settingMap(1, 0, 0, 1, 1);
////            System.out.println("group : " + 1);
////            System.out.println("total : " + 0);
//        } else if (N == 1) {
//            return settingMap(2, 1, 1, 1, 2);
////            System.out.println("group : " + 2);
////            System.out.println("total : " + 1);
//        }
        /* X그룹 구하기 관련 변수 */
        int group = params.get("group");
        int startNumber = params.get("startNumber");
        int endNumber = params.get("endNumber");
        int startPlus = params.get("startPlus");
        int endPlus = params.get("endPlus");


        boolean finish = false;

        while (!finish) {
            System.out.println(">>> ======== group : " + (group) + " ======== ");
            System.out.println(">>> startNumber : " + (startNumber) + " / endNumber : " + endNumber);
            System.out.println(">>> startPlus : " + (startPlus));
            System.out.println(">>> startNumber = startNumber + startPlus : " + (startNumber + startPlus) + " / endNumber = endNumber + endPlus : " + (endNumber + endPlus));

            startNumber = startNumber + startPlus;
            endNumber = endNumber + endPlus;

            System.out.println(">>> total-1 : " + (startNumber-1));
            startPlus = startNumber-1;
            endPlus = endPlus * 2;
            System.out.println("--------------------->  " + startNumber + " < N < " + endNumber + " **** ");
            if (startNumber <= N && N <= endNumber) {
                finish = true;
            }
            group ++;
        }

        System.out.println(">>> ============================== ");
        System.out.println("group : " + group);
        System.out.println("total : " + startNumber);
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

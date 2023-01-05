package com.study.javaalgorithm.codility.lesson2;

import java.util.HashMap;

/**
 * url: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println("result: " + solution(new int[] {9,3,9,3,9,7,9}));
    }

    public static int solution(int[] A) {
        HashMap<Integer, Boolean> check = new HashMap<>();

        for (int num : A) {
            if (check.containsKey(num)) {
                check.remove(num);
            } else {
                check.put(num, Boolean.FALSE);
            }
        }

        return check.keySet().iterator().next();
    }
}

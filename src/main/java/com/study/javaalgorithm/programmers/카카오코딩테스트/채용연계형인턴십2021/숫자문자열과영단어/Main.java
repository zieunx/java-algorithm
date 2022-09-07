package com.study.javaalgorithm.programmers.카카오코딩테스트.채용연계형인턴십2021.숫자문자열과영단어;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("정답: " + solution.solution("123"));
    }
}

class Solution {
    public int solution(String s) {

        Iterator<String> iterator = NumberTable.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            s = s.replaceAll(next, String.valueOf(NumberTable.getNumber(next)));
        }

        return Integer.parseInt(s);
    }
}

class NumberTable {
    private static Map<String, Integer> data;

    static {
        data = new HashMap<>();

        data.put("zero", 0);
        data.put("one", 1);
        data.put("two", 2);
        data.put("three", 3);
        data.put("four", 4);
        data.put("five", 5);
        data.put("six", 6);
        data.put("seven", 7);
        data.put("eight", 8);
        data.put("nine", 9);
    }


    public static Iterator<String> iterator() {
        return data.keySet().iterator();
    }

    public static int getNumber(String numberText) {
        return data.get(numberText);
    }
}
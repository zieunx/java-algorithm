package com.study.javaalgorithm.test.d.n1;

public class Solution {

    public int solution(String p, String s) {
        int answer = 0;

        for (int i = 0; i < p.length(); i++) {
            int a = Math.abs(Character.getNumericValue(p.charAt(i)) - Character.getNumericValue(s.charAt(i)));
            int b = 10 - a;

            answer += Math.min(a, b);
        }

        return answer;
    }
}

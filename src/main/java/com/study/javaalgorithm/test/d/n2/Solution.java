package com.study.javaalgorithm.test.d.n2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int solution(String[] moves) {

        Set<String> checker = new HashSet<>();

        for (String move : moves) {
            if (checker.contains(move)) {

            } else {
                checker.add(move);
            }

            if (checker.size() == 4) {

            }
        }
        return 0;
    }
}

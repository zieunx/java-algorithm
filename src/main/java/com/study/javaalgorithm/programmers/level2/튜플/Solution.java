package com.study.javaalgorithm.programmers.level2.튜플;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public List<Integer> solution(String s) {
        s = cropBucket(s);

        List<Set<Integer>> list = new ArrayList<>();

        String[] split = s.split("}");

        for (String tupleText : split) {
            Set<Integer> tuple = new HashSet<>();
            tupleText = tupleText.replaceAll("\\{", "");
            Stream.of(tupleText.split(","))
                    .filter(text -> !text.isBlank())
                    .forEach(text -> tuple.add(Integer.valueOf(text)));
            list.add(tuple);
        }

        list.sort(Comparator.comparingInt(Set::size));

        List<Integer> result = new ArrayList<>();

        for (Set<Integer> tupleSet : list) {
            tupleSet.forEach(value -> {
                if (!result.contains(value)) {
                    result.add(value);
                }
            });
        }

        return result;
    }

    public String cropBucket(String s) {
        return s.substring(1, s.length() - 1);
    }
}

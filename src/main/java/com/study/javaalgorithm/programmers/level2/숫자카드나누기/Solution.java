package com.study.javaalgorithm.programmers.level2.숫자카드나누기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Test test = new Test();

        int[] arrayA = {10,17};
        int[] arrayB = {5,20};
        test.solution(arrayA, arrayB);
    }

    static class Test {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;
            List<Integer> commonDivisorFromA = calculateCommonDivisor(arrayA);
            List<Integer> commonDivisorFromB = calculateCommonDivisor(arrayB);

            for (int card : commonDivisorFromA) {
                // A의 공약수가 있다면, B는 모든 숫자가 나눠지지 않는지만 확인하면 된다.
                if (cantDivideAll(card, arrayB)) {
                    answer = Math.max(card, answer);
                }
            }
            for (int card : commonDivisorFromB) {
                // B의 공약수가 있다면, A는 모든 숫자가 나눠지지 않는지만 확인하면 된다.
                if (cantDivideAll(card, arrayA)) {
                    answer = Math.max(card, answer);
                }
            }

            return answer;
        }

        private List<Integer> calculateCommonDivisor(int[] array) {
            List<Integer> list = new ArrayList<>();
            int min = array[0];

            while (min > 0) {
                int finalMin = min;
                if (Arrays.stream(array).allMatch(item -> item % finalMin == 0)) {
                    list.add(min);
                }
                min--;
            }

            return list;
        }

        private boolean cantDivideAll(int number, int[] array) {
            for (int item : array) {
                if (item % number == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

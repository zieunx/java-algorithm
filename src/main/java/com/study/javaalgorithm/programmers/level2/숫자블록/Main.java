package com.study.javaalgorithm.programmers.level2.숫자블록;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] result = solution(1_000_000_000 - 9, 1_000_000_000);// [0, 1, 1, 2, 1, 3, 1, 4, 3, 5]

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        // start == begin, end == end - begin - 1

        for (int i = 0; i < answer.length; i++) {
            long block = i + begin;
            int maxDivisor = calculateMaxDivisor(block);
            answer[i] = maxDivisor;
        }

        return answer;
    }

    private static int calculateMaxDivisor(long index) {
        System.out.println("index = " + index);
        if (index == 1) {
            return 0;
        }

        int result = 1;
        for(int i = 2; i <= Math.sqrt(index); i++){
            if (isDivisor(index, i)) {
                long value = index / i;
                if(value <= result) {
                    break;
                }
            }
        }

        return result;
    }

    private static boolean isDivisor(long index, int n) {
        return index % n == 0;
    }
}

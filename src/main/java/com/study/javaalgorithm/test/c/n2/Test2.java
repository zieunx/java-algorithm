package com.study.javaalgorithm.test.c.n2;

public class Test2 {
    public int solution(long[] arr) {
        int answer = 0;

        int i = 1;
        long difference = arr[1] - arr[0];

        int max = 0;

        int start = 0;
        int end = 1;
        while (i < arr.length) {
            long currentDiff = arr[i] - arr[i - 1];
            // System.out.printf("start: %d, end: %d / max: %d\n", start, end, max);

            if (difference == currentDiff) {
                end = i;
            } else {
                start = i - 1;
                end = i;
                difference = currentDiff;
            }

            if (max < (end - start) + 1) {
                max = (end - start) + 1;
            }

            i++;
        }

        answer = Math.max(end - start, max);

        return answer;
    }
}

package com.study.javaalgorithm.programmers.level3.입국심사;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println("result = " + solution(6, new int[] {7, 10}));
        System.out.println("result = " + solution(7, new int[] {10, 10}));
    }

    public static int solution(int n, int[] times) {
        Arrays.sort(times);
        int left = times[0];
        int right = times[times.length - 1] * n;
        int mid = (right + left) / 2;

        int min = right;
        while (left <= right) {
            System.out.printf("left: %d, mid: %d, right: %d\n", left, mid, right);
            int count = 0;

            for (int time : times) {
                count += mid / time;
            }

            System.out.printf("count = %d\n", count);

            if (n <= count) {
                right = mid - 1;
                min = mid;
                System.out.println("-> min update!");
            } else {
                left = mid + 1;
            }
            mid = (right + left) / 2;
        }

        return min;
    }
}

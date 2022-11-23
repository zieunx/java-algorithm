package com.study.javaalgorithm.programmers.level3.입국심사;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Test test = new Test();

        int n = 6;
        int[] times = {7, 10};

        System.out.println("result: " + test.solution(n, times));
    }

    static class Test {
        // 이분탐색의 포인트 : 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
        public long solution(int n, int[] times) {
            long answer = 0;

            Arrays.sort(times);

            long left = times[0];
            long right = (long) times[times.length - 1] * n;
            long mid = (left + right) / 2;

            while (left <= right) {
                long memberCount = 0;

                for (int time : times) {
                    memberCount += (mid / time);
                }
                if (n > memberCount) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    answer = mid;
                }

                mid = (left + right) / 2;
            }

            return answer;
        }
    }
}

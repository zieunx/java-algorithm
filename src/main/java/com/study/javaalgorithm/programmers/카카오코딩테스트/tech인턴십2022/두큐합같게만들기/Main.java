package com.study.javaalgorithm.programmers.카카오코딩테스트.tech인턴십2022.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
        System.out.println(solution.solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
        System.out.println(solution.solution(new int[] {1, 1}, new int[] {1, 5}));
    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long aSum = 0;
        long bSum = 0;
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            queueA.add(queue1[i]);
            queueB.add(queue2[i]);
            aSum += queue1[i];
            bSum += queue2[i];
        }

        return matchingSum(queueA , aSum, queueB, bSum);
    }

    private int matchingSum(Queue<Integer> queueA, long aSum, Queue<Integer> queueB, long bSum) {
        int count = 0;

        while (aSum != bSum) {
            count++;
            if (aSum > bSum) {
                int popA = queueA.poll();
                queueB.add(popA);
                aSum = aSum - popA;
                bSum = bSum + popA;
            } else {
                int popB = queueB.poll();
                queueA.add(popB);
                aSum = aSum + popB;
                bSum = bSum - popB;
            }

            if (count > (queueA.size() + queueB.size()) * 2) {
                return -1;
            }
        }

        return count;
    }
}

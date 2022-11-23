package com.study.javaalgorithm.codility.lesson2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class CyclicRotation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputA = {3, 8, 9, 7, 6};
        int inputK = 3;

        inputA = solution.solution(inputA, inputK);
        for (int a : inputA) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    static class Solution {
        public int[] solution(int[] A, int K) {
            // write your code in Java SE 8
            Deque<Integer> queueA = arrayToQueue(A);
            IntStream.range(1, K + 1)
                    .forEach(i -> queueA.addFirst(queueA.pollLast()));

            return queueToArray(queueA, A);
        }

        private int[] queueToArray(Deque<Integer> queueA, int[] A) {
            int index = 0;
            for (Integer a : queueA) {
                A[index] = a;
                index++;
            }

            return A;
        }

        private Deque<Integer> arrayToQueue(int[] A) {
            Deque<Integer> queue = new LinkedList<>();
            for (int a : A) {
                queue.add(a);
            }
            return queue;
        }
    }
}

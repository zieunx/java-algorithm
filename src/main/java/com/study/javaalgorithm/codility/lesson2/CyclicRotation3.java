package com.study.javaalgorithm.codility.lesson2;

public class CyclicRotation3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] inputA = {3, 8, 9, 7, 6};
//        int inputK = 2;
        int[] inputA = {1,2,3,4};
        int inputK = 4;

        inputA = solution.solution(inputA, inputK);

        for (int a : inputA) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    static class Solution {
        public int[] solution(int[] A, int K) {
            int[] result = new int[A.length];

            for (int i = 0; i < A.length; i++) {
                result[(i + K) % A.length] = A[i];
            }

            return result;
        }
    }
}


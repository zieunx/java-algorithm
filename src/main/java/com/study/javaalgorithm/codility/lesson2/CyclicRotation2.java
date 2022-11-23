package com.study.javaalgorithm.codility.lesson2;

public class CyclicRotation2 {
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

            K = K % A.length;
            System.out.println("K = " + K);

            if (K == 0) {
                return A;
            }

            for (int i = 0; i < result.length; i++) {
                if ((i + K - 1) < result.length) {
                    System.out.println("[i + K]: " + (i + K - 1));
                    result[i] = A[i + K - 1];
                } else {
                    System.out.println("[else ]: " + (i + K - result.length - 1));
                    result[i] = A[i + K - result.length - 1];
                }
            }

            return result;
        }
    }
}


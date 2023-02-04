package com.study.javaalgorithm.test.d;

import com.study.javaalgorithm.test.d.n4.Solution;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution: " + solution.solution(new int[][] {
                {0,0,0,0,2,0,0,0,0,0},
                {0,0,1,1,1,1,1,0,0,0},
                {0,0,1,1,1,1,1,1,0,0},
                {0,0,1,1,1,1,1,0,1,0},
                {0,0,1,1,1,1,1,0,0,0},
                {0,0,0,0,3,0,0,0,1,0},
        }, 2));
    }
}

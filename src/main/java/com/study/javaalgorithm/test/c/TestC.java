package com.study.javaalgorithm.test.c;

import com.study.javaalgorithm.test.c.n4.Test4;

import java.util.Arrays;

public class TestC {
    public static void main(String[] args) {
        Test4 test4 = new Test4();

        int[][] blocks = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};

        System.out.println("test4 result: " + Arrays.toString(test4.solution(blocks)));
    }
}

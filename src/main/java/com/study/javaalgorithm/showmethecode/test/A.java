package com.study.javaalgorithm.showmethecode.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 약수의 합 2
 * https://www.acmicpc.net/problem/17427
 */
public class A {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());

        long answer = 0;
        for(int i = 1; i <= N; i++) {
            answer += (long) (N / i) * i;
        }

        System.out.println(answer);
    }
}

package com.study.javaalgorithm.beakjoon.dp.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int N = Integer.parseInt(input());
        int[] inputs = Arrays.stream(input().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = -1000;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum += inputs[j];
                max = Math.max(max, sum);
            }
            sum = 0;
        }

        System.out.println(max);
    }

    private static String input() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

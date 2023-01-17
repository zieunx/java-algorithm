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
        int[] remembers = new int[N];

        int max = inputs[0];
        remembers[0] = max;
        for (int i = 1; i < N; i++) {
            int remember = Math.max(inputs[i], remembers[i -1] + inputs[i]);

            max = Math.max(remember, max);
            System.out.println("remember = " + remember);
            remembers[i] = remember;
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

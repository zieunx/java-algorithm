package com.study.javaalgorithm.beakjoon.백트래킹.N과M1_1;

import java.io.*;

/*
백준 백트레킹 N과 M (1)
https://www.acmicpc.net/problem/10816
 */
public class Main {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputData = inputReader.readLine().split(" ");

        int N = Integer.parseInt(inputData[0]);
        int M = Integer.parseInt(inputData[1]);

        int[] array = new int[N];

        for (int i = 1; i <= N; i++) {
            array[i - 1] = i;
        }

        combination(array, new boolean[N], M, 0, new int[M]);

        writer.flush();
        writer.close();
    }

    public static void combination(int[] array, boolean[] visited, int combSize, int count, int[] result) throws IOException {
        if (combSize == count) {
            // 출력
            for (int i : result) {
                writer.write(i + " ");
            }
            writer.write("\n");
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[count] = array[i];
            combination(array, visited, combSize, count + 1, result);
            visited[i] = false;
        }
    }
}

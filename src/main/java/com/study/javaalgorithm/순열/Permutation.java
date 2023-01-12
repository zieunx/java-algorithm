package com.study.javaalgorithm.순열;

public class Permutation {
    public static void main(String[] args) {
        int[] input = {1,2,3};
        int[] output = new int[input.length];
        boolean[] visited = new boolean[input.length];

        for (int i = 1; i <= input.length; i++) {
            permutation(input, output, visited, 0, i);
        }
    }

    static void permutation(int[] input, int[] output, boolean[] visited, int depth, int size) {
        if (depth == size) {
            print(output, size);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[depth] = input[i];
            permutation(input, output, visited, depth + 1, size);
            visited[i] = false;
        }
    }

    static void print(int[] output, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(output[i] + "");
        }
        System.out.println();
    }
}

package com.study.javaalgorithm.조합;

/*
 * 조합 기본유형 1
 * 중복 없이 조합 찾기
 **/
public class Type1Main {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};

        allCombination(list);
    }

    private static void allCombination(int[] list) {
        boolean[] visited = new boolean[list.length];

        int start = 0;
        int size = 2;
        combination(list, visited, start, size, size);
    }

    private static void combination(int[] list, boolean[] visited, int start, int size, int depth) {
        if (depth == 0) {
            print(list, visited, size);
        }

        for (int i = start; i < list.length; i++) {
            visited[i] = true;
            combination(list, visited, i + 1,size, depth - 1);
            visited[i] = false;
        }
    }

    private static void print(int[] list, boolean[] visited, int size) {
        for (int i = 0; i < visited.length; i++) {
            if (size == 0) {
                break;
            }
            if (visited[i]) {
                System.out.print(list[i] + " ");
                size--;
            }
        }
        System.out.println();
    }
}

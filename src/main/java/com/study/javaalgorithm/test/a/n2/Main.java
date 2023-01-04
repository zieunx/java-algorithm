package com.study.javaalgorithm.test.a.n2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3, new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 0, 0}})));
//        System.out.println(solution(3, new int[][] {{0,0,1},{0,0,1},{0,1,0}}));
    }

    public static int[][] solution(int n, int[][] signs) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("====== (%d, %d) ======\n", i, j);
                result[i][j] = checker(signs, new boolean[n][n], new int[] {i, j}, i);
            }
        }
        return result;
    }

    public static int checker(int[][] signs, boolean[][] visited, int[] location, int destination) {
        System.out.printf("-> (%d,%d)\n", location[0], location[1]);
//        if (visited[location[0]][location[1]]) {
//            System.out.printf("    이미방문했어요 ... 찾기 종료! (%d,%d)\n", location[0], location[1]);
//            return 0;
//        }
        if (location[1] == destination && signs[location[0]][location[1]] == 1) {
            System.out.println("    도착할 수 있네요!");
            return 1;
        }
        visited[location[0]][location[1]] = true;
        System.out.println("visited : " + Arrays.deepToString(visited));

//        int result = 0;
        int targetStation = location[0];
//        System.out.println("   행 순회 시작: " + targetStation);
        for (int i = 0; i < signs.length; i++) {
            // 다음 정류장이 이동 가능한 정류장이면
            System.out.printf(" .... (%d,%d)\n", targetStation, i);
            if (visited[targetStation][i]) {
                continue;
            }
            if (signs[targetStation][i] == 1) {
                location[0] = i;
                location[1] = 0;
                System.out.printf("    다음 정류장 이동 가능하네요! next (%d, %d) -> %d행\n", targetStation, i, i);
//                visited[location[0]][location[1]] = true;
                System.out.println("[call]");
                if (checker(signs, visited, location, destination) == 1) {
                    return 1;
                }
//                visited[location[0]][location[1]] = false;
            }
        }
        return 0;
    }

    public static int[][] solution2(int n, int[][] signs) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("====== (%d, %d) ======\n", i, j);
                checker2(signs, new boolean[n][n], new int[] {i, j}, result);
            }
        }
        return result;
    }

    public static void checker2(int[][] signs, boolean[][] visited, int[] location, int[][] result) {
        System.out.printf("> (%d,%d)\n", location[0], location[1]);
        if (visited[location[0]][location[1]]) {
//            System.out.printf("  이미방문했어요 ... 찾기 종료! (%d,%d)\n", location[0], location[1]);
            return;
        }
        if (signs[location[0]][location[1]] != 1) {
            System.out.printf("  갈수없는정류장이네요 ... 찾기 종료! (%d,%d)\n", location[0], location[1]);
            return;
        }
        visited[location[0]][location[1]] = true;
        result[location[0]][location[1]] = 1;
        System.out.println("  visited : " + Arrays.deepToString(visited));

        int targetStation = location[1];
        for (int i = 0; i < signs.length; i++) {
            location[0] = targetStation;
            location[1] = i;
            checker2(signs, visited, location, result);
//            visited[location[0]][location[1]] = false;
        }
    }
}

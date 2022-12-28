package com.study.javaalgorithm.beakjoon.백트래킹.N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
//    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(inputReader.readLine());
        int[] checker = new int[n];

        checkNQueen(n, checker, 0);

        System.out.println(count);
        inputReader.close();
    }

    // dfs
    private static void checkNQueen(int n, int[] checker, int row) {
//        System.out.println("row: " + row);
        if (row == n) {
            count ++;
            return;
        }

        for (int col = 0; col < n; col++) {
            checker[row] = col;
            if (canAttack(checker, row)) {
                checkNQueen(n, checker, row + 1 );
            }
        }
    }

    private static boolean canAttack(int[] arr, int row) {
        for (int targetRow = 0; targetRow < row; targetRow++) {
            // 같은 줄에 퀸이 있는지 확인
            if (arr[targetRow] == arr[row]) {
                return false;
            }
            // 대각선에 퀸이 있는지 확인 == row 의 차이와 column 의 차이가 같으면 대각선
            if (Math.abs(row - targetRow) == Math.abs(arr[row] - arr[targetRow])) {
                return false;
            }
        }
        return true;
    }
}

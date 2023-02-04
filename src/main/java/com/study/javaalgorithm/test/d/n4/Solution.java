package com.study.javaalgorithm.test.d.n4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    private final int MOVE_ENERGY = 1;
    private final int[][] DIRECTION = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private int min = Integer.MAX_VALUE;

    public int solution(int[][] board, int c) {

        dfs(board, c);

        return min;
    }

    void dfs(int[][] board, int c) {
        int[] robot = findRobot(board); // 시작 좌표
        boolean[][] visited = new boolean[board.length][board[0].length];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] {robot[0], robot[1], 0});



        while (!stack.empty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            System.out.println(Arrays.toString(current));

            if (board[x][y] == 3) {
                min = Math.min(min, current[2]);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + DIRECTION[i][0];
                int nextY = y + DIRECTION[i][1];

                if (nextX < 0 || nextX > board.length - 1 || nextY < 0 || nextY > board[0].length - 1) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    int power = current[2] + MOVE_ENERGY;
                    if (board[nextX][nextY] == 1) {
                        power += c;
                    }
                    visited[nextX][nextY] = true;
                    stack.add(new int[] {nextX, nextY, power});
                }
            }
        }
    }

    void bfs(int[][] board, int c, boolean[][] visited) {
        int[] robot = findRobot(board); // 시작 좌표
        visited[robot[0]][robot[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {robot[0], robot[1], 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            System.out.println(Arrays.toString(current));

            if (board[x][y] == 3) {
                min = Math.min(min, current[2]);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + DIRECTION[i][0];
                int nextY = y + DIRECTION[i][1];

                if (nextX < 0 || nextX > board.length - 1 || nextY < 0 || nextY > board[0].length - 1) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    int power = current[2] + MOVE_ENERGY;
                    if (board[nextX][nextY] == 1) {
                        power += c;
                    }
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY, power});
                }
            }
        }
    }

    private int[] findRobot(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}

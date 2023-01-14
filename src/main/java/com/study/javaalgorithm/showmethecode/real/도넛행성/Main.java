package com.study.javaalgorithm.showmethecode.real.도넛행성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final static int[] dx = { -1, 1, 0, 0 };
    private final static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // 데이터 초기화
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 상하
        int M = Integer.parseInt(input[1]); // 좌우

        List<Spot> queue = new LinkedList<>();

        int[][] planet = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                planet[i][j] = Integer.parseInt(line[j]);
                if (planet[i][j] == 0) {
                    queue.add(new Spot(i, j));
                }
            }
        }

        // 구역찾기
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        while (!queue.isEmpty()) {
            Spot spot = queue.get(0);
            queue.remove(0);

            if (!visited[spot.x][spot.y]) {
                dfs(planet, spot.x, spot.y, visited, queue);
                count += 1;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int[][] planet, int x, int y, boolean[][] visited, List<Spot> queue) {
//        System.out.printf("(%d, %d)\n", x, y);
        visited[x][y] = true;
//        System.out.println(Arrays.deepToString(visited));

        for (int i = 0; i < 4; i++) {
            int nextX = getNextX(dx, i, x, planet.length);
            int nextY = getNextX(dy, i, y, planet[0].length);

            if (!visited[nextX][nextY] && planet[nextX][nextY] == 0) {
                queue.remove(new Spot(x, y));
                dfs(planet, nextX, nextY, visited, queue);
            }
        }
    }

    private static int getNextX(int[] direction, int i, int spot, int size) {
        int next = direction[i] + spot;
        if (size == next) {
            next = 0;
        } else if (-1 == next) {
            next = size - 1;
        }
        return next;
    }


    static class Spot {
        private int x;
        private int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Spot spot = (Spot) o;

            if (x != spot.x) return false;
            return y == spot.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}

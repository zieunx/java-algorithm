package com.study.javaalgorithm.showmethecode.real.도넛행성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/27211
 */
public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final static int[] dx = { -1, 1, 0, 0 };
    private final static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        // 데이터 초기화
        int N = Integer.parseInt(st.nextToken()); // 상하
        int M = Integer.parseInt(st.nextToken()); // 좌우

        int[][] planet = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
                if (planet[i][j] != 0) {
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                count += 1;
                Queue<Spot> queue = new LinkedList<>();
                queue.add(new Spot(i, j));

                while (!queue.isEmpty()) {
                    Spot spot = queue.poll();

                    for (int direction = 0; direction < 4; direction++) {
                        int nextX = getNext(dx, direction, spot.x, planet.length);
                        int nextY = getNext(dy, direction, spot.y, planet[0].length);

                        if (!visited[nextX][nextY] && planet[nextX][nextY] == 0) {
                            queue.add(new Spot(nextX, nextY));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    // bfs
    private static void visitSameArea(int[][] planet, int x, int y, boolean[][] visited, Queue<Spot> queue) {
//        System.out.printf("(%d, %d)\n", x, y);
        visited[x][y] = true;
//        System.out.println(Arrays.deepToString(visited));

        for (int i = 0; i < 4; i++) {
            int nextX = getNext(dx, i, x, planet.length);
            int nextY = getNext(dy, i, y, planet[0].length);

            if (!visited[nextX][nextY] && planet[nextX][nextY] == 0) {
                visitSameArea(planet, nextX, nextY, visited, queue);
            }
        }
    }

    private static int getNext(int[] direction, int i, int spot, int size) {
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

package com.study.javaalgorithm.beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class n1012 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] inputArr;
    static int M; // 가로
    static int N; // 세로
    static int K; // 배추의 개수
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    static Queue<int[]> queue = new LinkedList<>();
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(reader.readLine()); // test 개수
        StringBuilder result = new StringBuilder();

        // 배열 초기화
//        for (int i = 0; i < 51; i ++) {
//            for (int j = 0; j < 51; j ++) {
//                area[i][j] = 0;
//                visited[i][j] = 0;
//            }
//        }

        for (int i = 0; i < T; i++) {
            result.append(find()).append("\n");
        }

        writer.write(result + "\n");
        writer.flush();

        writer.close();
        reader.close();
    }

    static int find() throws IOException {
        inputArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        M = inputArr[0]; // 가로
        N = inputArr[1]; // 세로
        K = inputArr[2]; // 배추의 개수
        count = 0;


        area = new int[M][N];
        visited = new boolean[M][N];

        // 테스트 배추 세팅.
        for (int i = 0; i < K; i ++) {
            int[] spot = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
//            System.out.println("  > spot : " + Arrays.toString(spot));
            area[spot[0]][spot[1]] = 1;
        }

        // 지우자. 이것은.
//        for (int i = 0; i < area.length; i ++) {
//            for (int j = 0; j < area[0].length; j ++) {
//                System.out.print("[" + area[i][j] +  "]  ");
//            }
//            System.out.print("\n");
//        }

        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                if (area[i][j] == 1 && !visited[i][j]) {
//                    System.out.println("count !  ------ " + i + ", " + j);
                    count++;
                    visitGroup(i ,j);
                }
            }
        }

//        System.out.println("<개수> " + count);
        // 지우자. 이것은.
//        for (int i = 0; i < area.length; i ++) {
//            for (int j = 0; j < area[0].length; j ++) {
//                System.out.print("[" + area[i][j] +  "]  ");
//            }
//            System.out.print("\n");
//        }
        return count;
    }

    static void visitGroup(int startX, int startY) {
        queue.offer(new int[]{startX, startY}); // 그룹의 시작점 queue에 추가
        while (!queue.isEmpty()) {
            x = queue.peek()[0]; // peek: 첫번째 값 조회.
            y = queue.peek()[1];
            queue.poll(); // poll: 꺼내고 제거.
            visited[x][y] = true;
            area[x][y] = count;

//            System.out.println(" this is [" + x + ", " + y + "]");

            for (int i = 0; i < 4; i ++) {
                int aroundX = x + dx[i];
                int aroundY = y + dy[i];
                if (
                        aroundX >= 0 && aroundY >= 0 && aroundX < M && aroundY < N &&
                                area[aroundX][aroundY] == 1 && !visited[aroundX][aroundY]
                ) {
                    visited[aroundX][aroundY] = true;
//                    System.out.println("around x : " + aroundX + ", around x : " + aroundY);
                    queue.offer(new int[]{aroundX, aroundY});
                }
            }
        }
    }
}

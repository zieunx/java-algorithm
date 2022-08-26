package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2022.파괴되지않은건물;

import java.util.Arrays;

/*
누적합 활용하여 풀었다.
참고: https://blex.me/@mildsalmon/2022-kakao-blind-recruitment-%ED%8C%8C%EA%B4%B4%EB%90%98%EC%A7%80-%EC%95%8A%EC%9D%80-%EA%B1%B4%EB%AC%BC

 */
public class Main2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        // 타입,
        int result = solution.solution(
                new int[][] {{5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}},
                new int[][] {
                        {1,0,0,3,4,4}
                        ,
                        {1,2,0,2,3,2}
                        ,
                        {2,1,0,3,1,2}
                        ,
                        {1,0,1,3,3,1}
                }
        );
        System.out.println(result); // 10
    }
}

class Solution2 {
    public int solution(int[][] board, int[][] skill) {

        int[][] dealTotal = new int[board.length + 1][board[0].length + 1];

        // deal 기록
        for (int i = 0; i < skill.length; i++) {
            int deal = skill[i][5] * (skill[i][0] == 1 ? -1 : 1);
            int startX = skill[i][1];
            int startY = skill[i][2];
            int endX = skill[i][3];
            int endY = skill[i][4];

            dealTotal[startX][startY] += deal;
            dealTotal[endX + 1][endY + 1] += deal;
            dealTotal[startX][endY + 1] += deal * -1;
            dealTotal[endX + 1][startY] += deal * -1;
        }

        // row 누적합
        for (int i = 1; i < dealTotal.length; i++) {
            for (int j = 0; j < dealTotal[0].length; j++) {
                dealTotal[i][j] = dealTotal[i][j] + dealTotal[i - 1][j];
            }
        }

        // col 누적합
        for (int i = 0; i < dealTotal.length; i++) {
            for (int j = 1; j < dealTotal[0].length; j++) {
                dealTotal[i][j] = dealTotal[i][j] + dealTotal[i][j - 1];
            }
        }

        // 멀쩡한 건물 구하귀
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + dealTotal[i][j] >= 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

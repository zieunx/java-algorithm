package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2022.파괴되지않은건물;


/*
 * dfs 로 풀었으나 콜스택 많이쌓여서 실패 (정확성 53.8 + 효율성 0 = 53.8 점)
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

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

class Solution {
    int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    boolean[] visited;
    public int solution(int[][] board, int[][] skill) {

        for (int i = 0; i < skill.length; i++) {
            int deal = skill[i][5];
            if (skill[i][0] == 1) {
                deal = deal * -1;
            }
            applySkill(board, deal, skill[i][1], skill[i][2], skill[i][3], skill[i][4]);
        }

//        System.out.println("<board>");
//        System.out.println(Arrays.deepToString(board));

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void applySkill(int[][] board, int deal, int startX, int startY, int endX, int endY) {
        bfs(deal, board, startX, startY, new boolean[endX - startX + 1][endY - startY + 1], startX, startY, endX, endY);
    }

    private void bfs(int deal, int[][] board, int x, int y, boolean[][] visited, int startX, int startY, int endX, int endY) {
        if (x < 0 || x < startX || x > endX || x > board.length  ||
                y < 0 || y < startY || y > endY || y > board.length) {
            return;
        }
        if (visited[x - startX][y - startY]) {
            return;
        }
//        System.out.printf("current : (%d, %d)     ----->  start: (%d, %d), end: (%d, %d)\n", x, y, startX, startY, endX, endY);
        board[x][y] = board[x][y] + deal;
        // 방문처리
        visited[x - startX][y - startY] = true;

        for (int i = 0; i < 4; i++) {
            board[x][y] = board[x][y] + deal;
            // 방문처리
            visited[x - startX][y - startY] = true;
            bfs(deal, board, x + direction[i][0], y + direction[i][1], visited, startX, startY, endX, endY);
        }
    }

}

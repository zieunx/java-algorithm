package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
* 프로그래머스 제출용 코드
*
 class Solution {
    public int[] solution(int[][] v) {
        int[] answer = {0, 0};

        answer[0] = getKey(v, 0);
        answer[1] = getKey(v, 1);

        return answer;
    }

    private int getKey(int[][] v, int n) {
        if (v[0][n] == v[1][n]) {
            return v[2][n];
        } else {
            if (v[0][n] == v[2][n]) {
                return v[1][n];
            } else {
                return v[0][n];
            }
        }
    }
}
*
* */


public class 직사각형_좌표_구하기 {
    public static void main(String[] args) {
        int[][] v = new int[3][2];

        Scanner sc = new Scanner(System.in);

        for (int i=0; i<=2 ; i++) {
            System.out.println("==============");
            for (int j=0; j<=1; j++) {
                v[i][j] = sc.nextInt();
            }
        }

        int[] answer = {0, 0};

        answer[0] = getKey(v, 0);
        answer[1] = getKey(v, 1);

        System.out.println(Arrays.toString(answer));
        // return answer;
    }
    private static int getKey(int[][] v, int n) {
        if (v[0][n] == v[1][n]) {
            return v[2][n];
        } else {
            if (v[0][n] == v[2][n]) {
                return v[1][n];
            } else {
                return v[0][n];
            }
        }
    }
}

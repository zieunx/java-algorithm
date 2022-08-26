package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2022.양궁대회;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


/*
라이언이 가장 큰 점수 차이로 이겨야 한다
10점부터 0점까지 순서대로 주어진다
라이언이 우승할 수 없는 경우 -> [-1] 리턴
 */
public class Main {
    public static int[] result = new int[] { -1 };
    static int max = -1000;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(4, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})
        ));

//        System.out.println(Arrays.toString(
//                solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0})
//        ));
//
//        System.out.println(Arrays.toString(
//                solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1})
//        ));
//
//        System.out.println(Arrays.toString(
//                solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3})
//        ));
    }

    public static int[] solution(int n, int[] info) {
        int[] ryanScores = new int[info.length];
        int[] apacheScores = info;
//        int apacheMinScore = calculateMinScore(n, info);

        ryanScores = dfs(ryanScores, apacheScores, 0, n);
        return result;
    }

    private static int[] dfs(int[] ryanScores, int[] apacheScores, int cnt, int n) {
        if (cnt == n) {
            System.out.println("ryanScores : " + Arrays.toString(ryanScores));
//            int apeach_point = 0;
//            int lion_point = 0;
//            for(int i = 0; i <= 10; i++)
//            {
//                if(apacheScores[i] != 0 || ryanScores[i] != 0) {
//                    if(apacheScores[i] < ryanScores[i])
//                        lion_point += 10 - i;
//                    else
//                        apeach_point += 10 - i;
//                }
//            }
//            if(lion_point > apeach_point) {
//                if(lion_point - apeach_point >= max) {
//                    result = ryanScores.clone();
//                    max = lion_point - apeach_point;
//                }
//            }
            return ryanScores;
        }
        for(int i = 0; i <= 10 && ryanScores[i] <= apacheScores[i]; i++) {
            ryanScores[i] = ryanScores[i] + 1;
//            System.out.printf("i : %d / ryanScores : %s%n", i, Arrays.toString(ryanScores));
            dfs(ryanScores, apacheScores, cnt + ryanScores[i], n);
            ryanScores[i]--;
        }
        return ryanScores;
    }

    //점수 계산
    private static boolean isRyanWinner(int[] apacheScores, int[] ryanScores) {
        return true;
    }

    /*private static int[] dfs(int[] ryanScores, int[] apacheScores, int maxDepth, int start, int currentDepth) {
        if (maxDepth == currentDepth) {
            return ryanScores;
        }

        for (int i = start; i < 11; i++) {
            ryanScores[i] = apacheScores[i] + 1;
            dfs(ryanScores, apacheScores, maxDepth, i, currentDepth + 1);
            System.out.println("ryan score : " + Arrays.toString(ryanScores));
            ryanScores[i] = 0;
        }
        return ryanScores;
    }*/

    private static int calculateMinScore(int n, int[] info) {
        PriorityQueue<Integer> scores = new PriorityQueue<>();

        for (int i = 0; i < info.length; i++) {
            int score = info.length - (i + 1);
            if (score * info[i] != 0) {
                scores.add(score * info[i]);
            }
        }

        return scores.isEmpty() ? 0 : scores.peek();
    }
}

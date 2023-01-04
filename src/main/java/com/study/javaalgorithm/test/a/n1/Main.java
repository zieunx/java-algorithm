package com.study.javaalgorithm.test.a.n1;

public class Main {
    public static void main(String[] args) {
        System.out.println("" + solution(60, new int[][]{
                {60,1},{130,2},{240,4},{432,7}
        })); // 2
        System.out.println("" + solution(30, new int[][]{
                {60,3},{152,6},{240,9}
        })); // 1
    }


    public static int solution(int speed_limit, int[][] cameras) {
        int result = 0;

        int startLocation = 0;
        int startTime = 0;
        for (int[] camera : cameras) {
            int endLocation = camera[0];
            int endTime = camera[1];

            int distance = endLocation - startLocation;
            int time = endTime - startTime;

            if (Math.ceil((double) distance / (double) time) > speed_limit) {
                result += 1;
            }
            startLocation = endLocation;
            startTime = endTime;
        }

        return result;
    }
}

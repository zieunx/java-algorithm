package com.study.javaalgorithm.beakjoon;

import java.util.Scanner;

public class n4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        double[] avgArr = new double[c];
        int n, sum, avg, count, score;
        int[] arr;

        for (int i=0 ; i < c ; i++ ) {
            n = sc.nextInt();
            sum = 0;
            count = 0;
            arr = new int[n];
            for (int j=0 ; j < n ; j++) {
                score = sc.nextInt();
                arr[j] = score;
                sum += score;
            }
            avg = sum / n;
            for (int h=0 ; h < n ; h++) {
                if (arr[h] > avg) {
                    count ++;
                }
            }
            avgArr[i] = (double) count / (double)n ;
        }

        for (double v : avgArr) {
            System.out.printf("%.3f%%\n", v * 100);
        }

        sc.close();
    }
}

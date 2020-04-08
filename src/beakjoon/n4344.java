package beakjoon;

import java.util.Scanner;

public class n4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        double[] avgArr = new double[c];

        for (int i=1 ; i <= c ; i++ ) {
            int n = sc.nextInt();
            int sum = 0;
            int avg = 0;
            int count = 0;
            int[] arr = new int[n];
            for (int j=1 ; j <= n ; j++) {
                int score = sc.nextInt();
                sum += score;
                arr[j-1] = score;
                avg = sum / n;
            }
            for (int h=0 ; h < n ; h++) {
                if (arr[h] > avg) {
                    count ++;
                }
            }
            avgArr[i-1] = (double) count / (double)n ;
        }

        for (double v : avgArr) {
            System.out.printf("%.3f%%\n", v * 100);
        }
    }
}

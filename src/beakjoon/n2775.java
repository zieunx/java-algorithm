package beakjoon;

import java.util.Scanner;

public class n2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] answer = new int[testCase];
        int k, n;

        for (int i=0; i< testCase ;i++) {
            k = sc.nextInt();
            n = sc.nextInt();
            answer[i] = cal(k, n);
        }
        for (int i=0; i< testCase ;i++) {
            System.out.println(answer[i]);
        }
    }
    static int cal(int k, int n) {
        if (n == 1) {
            return 1;
        } else if (k == 0) {
            return n;
        } else {
            return cal(k, n-1) + cal(k-1, n);
        }
    }
}

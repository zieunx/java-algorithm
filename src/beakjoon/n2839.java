package beakjoon;

import java.util.Scanner;

public class n2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N%5 == 0) {
            System.out.println(N / 5);
        } else if (N%5 == 1) {
            System.out.println(N/5+1);
        } else if (N%5 == 2) {
            if (N/5 < 3) {
                System.out.println(-1);
            } else {
                System.out.println((N/5)-2+4);
            }
        } else if (N%5 == 3) {
            System.out.println((N-3) == 0 ? 1 : ((N - 3) / 5) + 1);
        } else if (N%5 == 4) {
            if (N%10 == 9) {
                System.out.println(3+2*(N/10));
            } else {
                System.out.println(N / 10 > 1 ? (N/5)+4 : -1);
            }
        }

        sc.close();
    }
}

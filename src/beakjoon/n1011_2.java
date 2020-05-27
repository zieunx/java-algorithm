package beakjoon;

import java.util.Scanner;

public class n1011_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int count = 1;
        int  X, Y, N, endNumber, endPlus;

        for (int i = 1; i <= T; i++ ) {
            X = sc.nextInt();
            Y = sc.nextInt() - 1;
            N = Y - X;
            if (N != 0) {
                count = 1;
                endNumber = 1;
                endPlus = 1;
                while (N > endNumber) {
                    count++;
//                    System.out.println("================ count : " + count + " ================");
                    endPlus *= 2;
                    endNumber += endPlus;
//                    System.out.println(">> endPlus : " + endPlus);
//                    System.out.println(">> endNumber : " + endNumber);
//                    count ++;
                }
                count ++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}

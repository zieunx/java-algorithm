package beakjoon;

import java.util.Scanner;

/*
* 시간제한 0.5초
* 메모리제한 256mb
* */
public class n1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = 1;
        int num = 0;
        while (getSum(n) < x) {
            num = getSum(n);
            n++;
        }
        num = x - num;
        if (n%2 == 1) {
            System.out.println((n+1)-num + "/" + num);
        } else {
            System.out.println(num + "/" + ((n+1)-num));
        }
    }
    static int getSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + getSum(n-1);
        }
    }
}

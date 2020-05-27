package beakjoon;

import java.util.*;

public class n10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = sc.nextInt();
        int min = max;

        for (int i=1 ; i<n ; i++) {
            int num = sc.nextInt();
            if (max < num) {
                max = num;
            } else
            if (num < min) {
                min = num;
            }
        }

        System.out.println(min +  " " + max);
        sc.close();
    }
}

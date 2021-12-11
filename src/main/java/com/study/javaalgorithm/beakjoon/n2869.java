package com.study.javaalgorithm.beakjoon;

import java.util.Scanner;

public class n2869 {
    public static void main(String[] args) {
        long A, B, V, day;
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        V = sc.nextLong();

        day = (V-B)%(A-B) == 0 ? (V-B)/(A-B) : (V-B)/(A-B)+1;
        System.out.println(day);

        sc.close();
    }
}

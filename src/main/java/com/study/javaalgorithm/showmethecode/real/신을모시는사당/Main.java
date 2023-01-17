package com.study.javaalgorithm.showmethecode.real.신을모시는사당;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 왼쪽 - 오른쪽 이 최대인 경우
        // 1의집합 - 2의집합이 최대인 경우
        // 1의집합의 최대값 - 2의 집합의 최소값
        int N = Integer.parseInt(reader.readLine());
        String[] rocks = reader.readLine().split(" ");

        int max = 0;

        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < N; i++) {
            int rock = Integer.parseInt(rocks[i]);
            if (isLeft(rock)) {
                leftCount += 1;
                rightCount -= 1;
            } else {
                rightCount += 1;
                leftCount -= 1;
            }

            if (leftCount < 0) {
                leftCount = 0;
            }
            if (rightCount < 0) {
                rightCount = 0;
            }

            max = Math.max(max, Math.max(leftCount, rightCount));
        }

        System.out.println(max);
    }

    private static boolean isLeft(int rock) {
        return rock == 1;
    }
}

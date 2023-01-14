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

        for (int t = 0; t < N; t++) {
            for (int i = 0; i < N - t; i++) {
                System.out.printf("%d 부터 %d 까지\n", i, N - t);
                int count = 0;
                for (int j = i; j < N - t; j++) {
                    if (Integer.parseInt(rocks[j]) == 1) {
                        count += 1;
                    } else {
                        count -= 1;
                    }
                }
                max = Math.max(max, Math.abs(count));
            }
        }

        System.out.println(max);
    }
}

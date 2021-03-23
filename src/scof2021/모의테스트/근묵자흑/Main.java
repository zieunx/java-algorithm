package scof2021.모의테스트.근묵자흑;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 최소값인 1을 찾는다.
        // 1부터 양쪽으로 업데이트
        // 양쪽 인덱스로부터 좌로 2개, 우로 2개씩 업데이트
        // 트리구조로 생각해도 되려나

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");


        int minNumberIndex = 0; // 1의 위치

        int frontIndex = 0;
        int backIndex = 0;

        System.out.println();

        System.out.println("Hello Goorm! Your input is " + input);

    }
}

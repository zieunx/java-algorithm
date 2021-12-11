package com.example.demo.programmers.level1.수박수박수박수박수박수;

public class Main {
    public static void main(String[] args) {

    }

    static String solution(int n) {
        String answer = "";

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                answer += "박";
            } else {
                answer += "수";
            }
        }

        return answer;
    }
}

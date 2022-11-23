package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2021.신규아이디추천;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {
//                "...!@bat#*..y.abcdefghijklm1209."
                "...!@BaT#*..y.abcdefghijklm",
                "z-+.^.",
                "=.=",
                "123_.def",
                "abcdefghijklmn.p"
        };


        for (String input : inputs) {
            System.out.println("answer : " + solution(input));
        }
    }

    public static String solution(String new_id) {
        // 1단계
        String s = new_id.toLowerCase();

        // 2단계
        s = s.replaceAll("[^a-z\\d\\-_.]*", "");

        // 3단계
        s = s.replaceAll("[.]+", ".");

        // 4단계
        if (s.matches("\\.(.*)")) {
            s = s.substring(1);
        }

        if (s.matches("(.*)\\.")) {
            s = s.substring(0, s.length() - 1);
        }

        // 5단계
        if (s.isEmpty()) {
            s = "a";
        }

        // 6단계
        if (s.length() >= 16) {
            s = s.substring(0, 15);
        }

        if (s.matches("(.*)\\.")) {
            s = s.substring(0, s.length() - 1);
        }

        // 7단계
        if (s.length() <= 2) {
//            s = s + String.valueOf(s.charAt(s.length() - 1)).repeat(3 - s.length());
        }


        return s;
    }
}

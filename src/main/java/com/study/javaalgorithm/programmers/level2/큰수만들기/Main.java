package com.study.javaalgorithm.programmers.level2.큰수만들기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        String answer = solution(input[0], Integer.parseInt(input[1]));

        System.out.print(answer);
    }

    private static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        // 문자열 int 리스트로 변환
        char[] numberCharList = number.toCharArray();
        int[] numberList = new int[numberCharList.length];
//        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < numberCharList.length; i++) {
            numberList[i] = Character.getNumericValue(numberCharList[i]);
//            numberList.add(Character.getNumericValue(numberCharList[i]));
        }

        /* 규칙 */
        //      * 뒤에서 (k-1)개 만큼은 고정 String이다.
        //      * (배열길이-k)개 가 정답 length이다.
        //      * (배열길이-k) - (k-1)  = 조합해야하는 숫자 길이.

        // 정답 전체 길이
        int answerLength = numberList.length - k;
        // 뒤의 고정 숫자 길이
        int fixedEndLength = k - 1;
        // 조합이 필요한 길이
        int todoLength = answerLength - fixedEndLength;

//        System.out.println(" answerLength : " + answerLength);
//        System.out.println(" fixedEndLength : " + fixedEndLength);
//        System.out.println(" todoLength : " + todoLength);
//        System.out.println("=====================================");

        // 0번째 인덱스 ~ (길이 - k) 번째 인덱스 중 최대 값 구하기
        int startIndex = 0;
        int endIndex = numberList.length - k - 1;
        StringBuilder makeAnswer = new StringBuilder();

        while (true) {
            if (
                    0 <= startIndex && startIndex < numberList.length
                    && 0 <= endIndex && endIndex < numberList.length
            ) {
                if (makeAnswer.toString().length() >= todoLength) {
                    break;
                }
                int indexOfMaxValue = indexOfMaxValue(startIndex, endIndex, numberList);
                // 숫자 추가
//                System.out.println(" >> makeAnswer.toString().length() : " + makeAnswer.toString().length());
//                System.out.println(" >> add num : " + numberList[indexOfMaxValue]);
                makeAnswer.append(numberList[indexOfMaxValue]);

                startIndex = indexOfMaxValue + 1;

//                System.out.println("    ! index : " + endIndex);
//                System.out.println("    ! (number.length() - k - 1) : " + (number.length() - k - 1));
                endIndex = endIndex >= (number.length() - k) ? endIndex : endIndex + 1;
            } else {
                break;
            }
        }

        String add = "";

        for (int n = (number.length() - k) + 1; n < number.length(); n++) {
            answer.append(number.charAt(n));
        }

        return makeAnswer.toString() + answer.toString();
    }

    private static int indexOfMaxValue(int startIndex, int endIndex, int[] list) {
        int max = list[startIndex];
        int maxIndex = startIndex;
//        System.out.println("-- startIndex : " + startIndex);
//        System.out.println("-- endIndex : " + endIndex);
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (list[i] > max) {
                max = list[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

package com.study.javaalgorithm.programmers.level2.이모티콘할인행사;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("result = " + Arrays.toString(solution(
                new int[][]{{40, 100000}, {25, 10000}},
                new int[]{7000, 9000}
        )));
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        int[] discountRates = new int[] {0, 10, 20, 30, 40};
        int[][] emoticonPrices = initEmoticonPrices(emoticons, discountRates);
        System.out.println("==== [emoticonPrices] ====\n" + Arrays.deepToString(emoticonPrices));

        for (int i = 0; i < users.length; i++) {
            int discountRateIndex = discountRates[discountRates.length - 1];

            while (0 <= discountRateIndex && users[i][0] <= discountRates[discountRateIndex]) {

                discountRateIndex--;
            }
        }

        return answer;
    }

    private static int[][] initEmoticonPrices(int[] emoticons, int[] emoticonDiscountRates) {
        int[][] emoticonPrices = new int[emoticons.length][emoticonDiscountRates.length];
        for (int i = 0; i < emoticons.length; i++) {
            for (int j = 0; j < 5; j++) {
                double rate = (double) (100 - emoticonDiscountRates[j]) / 100;
                emoticonPrices[i][j] = (int) (emoticons[i] * rate);
            }
        }
        return emoticonPrices;
    }
}

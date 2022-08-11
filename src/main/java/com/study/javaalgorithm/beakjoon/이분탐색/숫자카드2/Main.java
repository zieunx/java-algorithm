package com.study.javaalgorithm.beakjoon.이분탐색.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
백준 이분탐색 숫자카드2
https://www.acmicpc.net/problem/10816
 */
public class Main {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(inputReader.readLine());
        List<Integer> allCards = Arrays.stream(inputReader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int M = Integer.parseInt(inputReader.readLine());
        List<Integer> userCards = Arrays.stream(inputReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(String.join(" ", method(N, allCards, M, userCards)));
    }

    private static List<String> method(int n, List<Integer> allCards, int m, List<Integer> userCards) {
        List<String> answer = new ArrayList<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < userCards.size(); i++) {
            if (cache.containsKey(userCards.get(i))) {
                answer.add(answer.get(cache.get(userCards.get(i))));
            } else {
                answer.add(String.valueOf(countNumber(allCards, userCards.get(i))));
                cache.put(userCards.get(i), i);
            }
        }

        return answer;
    }

    private static int countNumber(List<Integer> allCards, int number) {
        int findIndex = binarySearch(allCards, number, 0, allCards.size() - 1);

        if (findIndex == -1) {
            return 0;
        }

        int count = 1;
        int lowIndex = findIndex - 1;
        int highIndex = findIndex + 1;
        while ((-1 < lowIndex) && allCards.get(lowIndex) == number) {
            count++;
            lowIndex--;
        }
        while ((allCards.size() > highIndex) && allCards.get(highIndex) == number) {
            count++;
            highIndex++;
        }
        return count;
    }

    public static int binarySearch(List<Integer> list, int target, int start, int end) {
        int mid;

        // 같은 숫자를 가진 인덱스 찾기
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == list.get(mid)) {
                return mid;
            } else if (target < list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

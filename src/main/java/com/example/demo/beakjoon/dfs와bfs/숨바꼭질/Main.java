package com.example.demo.beakjoon.dfs와bfs.숨바꼭질;

import java.io.*;
import java.util.*;

/*
* 동생을 만나는 deph를 구하면 되는 문제
* bfs를 사용
*
* fix: 리팩토링
*   중복되는 코드를 수정하기 위해 child 노드를 리스트화 하여 for문 사용
*   => 메모리와 시간을 더 사용하지만, 크게 문제되는 수준은 아니라고 판단.
* */
public class Main {
    static Map<Integer, Integer> visitedAndDepth = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int second = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArgs = reader.readLine().split(" ");

        int N = Integer.parseInt(inputArgs[0]); // 수빈. N(0 ≤ N ≤ 100,000)
        int K = Integer.parseInt(inputArgs[1]); // 동생. K(0 ≤ K ≤ 100,000)

        queue.add(N);
        visitedAndDepth.put(N, 0);

        findSisterByBfs(K);

        writer.write(second + "\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    static void findSisterByBfs(int destination) {
        Integer current = queue.poll();
        Integer nextDepth = visitedAndDepth.get(current) + 1;

        if (current == null) {
            return;
        }
        if (current == destination) {
            second = visitedAndDepth.get(current);
            return;
        }

        List<Integer> children = getChildrenSpot(current);

        for (Integer child : children) {
            if (canAddQueue(child)) {
                addQueue(child, nextDepth);
            }
        }

        findSisterByBfs(destination);
    }

    static List<Integer> getChildrenSpot(int current) {
        List<Integer> children = new ArrayList<>();
        children.add(current - 1);
        children.add(current + 1);
        children.add(current * 2);
        return children;
    }

    static boolean canAddQueue(int n) {
        return isNotVisited(n) && isInRange(n);
    }

    static void addQueue(int n, int depth) {
        queue.add(n);
        visitedAndDepth.put(n, depth);
    }

    static boolean isNotVisited(int n) {
        return !visitedAndDepth.containsKey(n);
    }

    static boolean isInRange(int n) {
        return 0 <= n && n <= 100000;
    }
}
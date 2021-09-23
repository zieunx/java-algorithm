package beakjoon.dfs와bfs.숨바꼭질;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
* 동생을 만나는 deph를 구하면 되는 문제
* bfs를 사용
* */
public class Main {

    final static int MIN = 0;
    final static int MAX = 0;

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

        int minusSpot = current - 1;
        int plusSpot = current + 1;
        int doubleSpot = current * 2;

        if (isNotVisited(minusSpot) && isInRange(minusSpot)) {
            queue.add(minusSpot);
            visitedAndDepth.put(minusSpot, nextDepth);
        }
        if (isNotVisited(plusSpot) && isInRange(plusSpot)) {
            queue.add(plusSpot);
            visitedAndDepth.put(plusSpot, nextDepth);
        }
        if (isNotVisited(doubleSpot) && isInRange(doubleSpot)) {
            queue.add(doubleSpot);
            visitedAndDepth.put(doubleSpot, nextDepth);
        }

        findSisterByBfs(destination);
    }

    static boolean isNotVisited(int n) {
        return !visitedAndDepth.containsKey(n);
    }

    static boolean isInRange(int n) {
        return 0 <= n && n <= 100000;
    }
}
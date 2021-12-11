package com.study.javaalgorithm.beakjoon.dfs와bfs.바이러스;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n2606_1 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] visited = {};
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int computerCount = Integer.parseInt(reader.readLine().trim()); // 컴퓨터의 수
        int pairCount = Integer.parseInt(reader.readLine().trim()); // 쌍의 수

        List<List<Integer>> graph = resetGraph(computerCount, pairCount);
        visited = new boolean[computerCount];

        // 너비 우선 탐색
        queue.add(0);
        dfs(graph);

        writer.write((count - 1) + "\n");
        writer.flush();

        reader.close();
        writer.close();
    }

    static void dfs(List<List<Integer>> graph) {
        Integer currentNode = queue.poll();

        if (currentNode == null) {
            return;
        }
        
        count++;
        visited[currentNode] = true;

        for (Integer childNode : graph.get(currentNode)) {
            if (!queue.contains(childNode) && !visited[childNode]) {
                queue.add(childNode);
            }
        }
        dfs(graph);
    }

    static List<List<Integer>> resetGraph(int N, int M) throws IOException {
        List<List<Integer>> graph = new LinkedList<>(new ArrayList<>());
        for (int i = 0; i < (N); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] pair = reader.readLine().split(" ");

            int indexA = Integer.parseInt(pair[0]) - 1;
            int indexB = Integer.parseInt(pair[1]) - 1;

            graph.get(indexA).add(indexB);
            graph.get(indexB).add(indexA);
        }
        return graph;
    }
}

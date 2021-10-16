package com.example.demo.beakjoon.dfs와bfs.BFS와DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

// <연결된 배열 활용>
// 정점이 여러개면 번호가 작은 것 부터 방문
public class n1260_1 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = {};

    public static void main(String[] args) throws IOException {

        String[] firstLineItems = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLineItems[0]); // 정점의 개수
        int M = Integer.parseInt(firstLineItems[1]); // 간선의 개수
        int V = Integer.parseInt(firstLineItems[2]); // 탐색 시작 정점 번호

        // 빈 그래프 초기화
        List<List<Integer>> graph = resetGraph(N, M);

        visited = new boolean[N];
        dfs(graph, V - 1);
        writer.write(stringBuffer.toString().trim() + "\n");

        visited = new boolean[N];
        stringBuffer = new StringBuffer();

        queue.add(V - 1);
        bfs(graph);
        writer.write(stringBuffer.toString().trim() + "\n");

        writer.flush();
        writer.close();
        reader.close();
    }

    // 깊이 우선 탐색
    private static void dfs(List<List<Integer>> graph, int currentNode) {
        visited[currentNode] = true;
        stringBuffer.append(currentNode + 1).append(" ");

        List<Integer> childrenItems = graph.get(currentNode).stream().sorted().collect(Collectors.toList());

        for (Integer childItem : childrenItems) {
            if (!visited[childItem]) {
                dfs(graph, childItem);
            }
        }
    }

    // 너비 우선 탐색
    private static void bfs(List<List<Integer>> graph) {
        Integer currentNode = queue.poll();

        if (currentNode == null) {
            return;
        }

        visited[currentNode] = true;
        stringBuffer.append(currentNode + 1).append(" ");

        List<Integer> childrenItems = graph.get(currentNode).stream().sorted().collect(Collectors.toList());

        for (Integer child : childrenItems) {
            if (!visited[child] && !queue.contains(child)) {
                queue.add(child);
            }
        }

        bfs(graph);
    }


    private static List<List<Integer>> resetGraph(int n, int M) throws IOException {
        List<List<Integer>> graph = new ArrayList<>(new LinkedList<>());
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] lineItems = reader.readLine().split(" ");
            int itemIndexA = Integer.parseInt(lineItems[0]) - 1;
            int itemIndexB = Integer.parseInt(lineItems[1]) - 1;

            graph.get(itemIndexA).add(itemIndexB);
            graph.get(itemIndexB).add(itemIndexA);
        }
        return graph;
    }

}

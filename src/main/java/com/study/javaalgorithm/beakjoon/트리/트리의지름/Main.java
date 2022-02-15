package com.study.javaalgorithm.beakjoon.트리.트리의지름;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static class Node {
		int node;
		int size;

		public Node(int node, int size) {
			this.node = node;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		int v = Integer.parseInt(reader.readLine());
		List<Node>[] list = new ArrayList[v + 1];

		for (int i = 0; i < v; i ++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < v; i ++) {
			String[] lineInputs = reader.readLine().split(" ");

			int root  = Integer.parseInt(lineInputs[0]);
			int endNum  = Integer.parseInt(lineInputs[lineInputs.length - 1]);
			for (int j = 1; j < lineInputs.length - 1; j = j + 2) {
				int node = Integer.parseInt(lineInputs[j]);
				int size = Integer.parseInt(lineInputs[j + 1]);
				list[root].add(new Node(node, size));
			}
		}
	}
}

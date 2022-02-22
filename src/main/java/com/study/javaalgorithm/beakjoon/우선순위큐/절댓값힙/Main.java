package com.study.javaalgorithm.beakjoon.우선순위큐.절댓값힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
			(o1, o2) -> Math.abs(o1) - Math.abs(o2) == 0 ? o1 - o2 : Math.abs(o1) - Math.abs(o2)
		);
		int N = Integer.parseInt(reader.readLine());

		int x;
		for (int i = 0; i < N; i = i + 1) {
			x = Integer.parseInt(reader.readLine());
			if (x == 0) {
				System.out.println(priorityQueue.isEmpty() ? 0 : priorityQueue.poll());
			} else {
				priorityQueue.add(x);
			}
		}

		reader.close();
	}
}

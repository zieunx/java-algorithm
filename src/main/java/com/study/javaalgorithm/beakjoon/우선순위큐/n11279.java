package com.study.javaalgorithm.beakjoon.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class n11279 {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

		int n = Integer.parseInt(reader.readLine());

		for (int i = 0; i < n; i = i + 1) {
			int x = Integer.parseInt(reader.readLine());
			if (x > 0) {
				priorityQueue.add(x);
			} else if (x == 0) {
				System.out.println(priorityQueue.isEmpty() ? 0 : priorityQueue.poll());
			}
		}

		reader.close();
	}
}

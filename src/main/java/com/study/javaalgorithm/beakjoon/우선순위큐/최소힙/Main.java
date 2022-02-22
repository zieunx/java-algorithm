package com.study.javaalgorithm.beakjoon.우선순위큐.최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		int N = Integer.parseInt(reader.readLine());

		int x = 0;
		for (int i = 0; i < N; i = i + 1) {
			x = Integer.parseInt(reader.readLine());
			if (x > 0) {
				priorityQueue.add(x);
			} else if (x == 0) {
				System.out.println(priorityQueue.isEmpty() ? 0 : priorityQueue.poll());
			}
		}

		reader.close();
	}
}

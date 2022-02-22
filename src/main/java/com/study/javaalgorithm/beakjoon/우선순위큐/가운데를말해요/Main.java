package com.study.javaalgorithm.beakjoon.우선순위큐.가운데를말해요;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		int N = Integer.parseInt(reader.readLine());

		int x;
		int target;
		for (int i = 0; i < N; i = i + 1) {
			x = Integer.parseInt(reader.readLine());
			compareBySize(minHeap, maxHeap).add(x);

			target = compareBySize(minHeap, maxHeap).peek();

			if (x == target) {
				System.out.println(x);
			} else if (x > target) {
				System.out.println(target);
			} else {

			}
		}

		reader.close();
	}

	public static PriorityQueue<Integer> compareBySize(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		return min.size() >= max.size() ? max : min;
	}
}

package com.study.javaalgorithm.beakjoon.이분탐색.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
* Map containKey 활용
* */
public class Main {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static String[] initInputValues() throws IOException {
		return reader.readLine().split(" ");
	}

	public static void main(String[] args) throws Exception {
		Map<Integer, Integer> aMap = new HashMap<>();
		int N = Integer.parseInt(reader.readLine());
		String[] inputValues = initInputValues();

		for (int i = 0; i < N; i = i + 1) {
			aMap.put(Integer.parseInt(inputValues[i]), 0);
		}

		int M = Integer.parseInt(reader.readLine());
		inputValues = initInputValues();

		for (int i = 0; i < M; i = i + 1) {
			System.out.println(aMap.containsKey(Integer.parseInt(inputValues[i])) ? 1 : 0);
		}

		reader.close();
	}
}

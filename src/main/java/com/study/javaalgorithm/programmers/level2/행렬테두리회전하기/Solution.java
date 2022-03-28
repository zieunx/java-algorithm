package com.study.javaalgorithm.programmers.level2.행렬테두리회전하기;

public class Solution {

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = initMap(rows, columns);

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i]; // 범위
			int startX = query[0] - 1;
			int startY = query[1] - 1;
			int endX = query[2] - 1;
			int endY = query[3] - 1;

			int temp = map[startX][startY];
			int nextValue;
			int min = temp;

			for (int a = startY; a < endY; a++) {
				nextValue = map[startX][a + 1];
				map[startX][a + 1] = temp;
				temp = nextValue;
				min = Math.min(min, temp);
			}
			for (int a = startX; a < endX; a++) {
				nextValue = map[a + 1][endY];
				map[a + 1][endY] = temp;
				temp = nextValue;
				min = Math.min(min, temp);
			}
			for (int a = endY; startY < a; a--) {
				nextValue = map[endX][a - 1];
				map[endX][a - 1] = temp;
				temp = nextValue;
				min = Math.min(min, temp);
			}
			for (int a = endX; startX < a; a--) {
				nextValue = map[a - 1][startY];
				map[a - 1][startY] = temp;
				temp = nextValue;
				min = Math.min(min, temp);
			}
			answer[i] = min;
		}

		return answer;
	}

	private void printMap(int[][] map) {
		System.out.println("----------------------------");
		for (int i = 0 ; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.printf(" %02d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

	public int[][] initMap(int rows, int columns) {
		int value = 1;
		int[][] map = new int[rows][columns];
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < columns; j ++) {
				map[i][j] = value;
				value++;
			}
		}
		return map;
	}
}

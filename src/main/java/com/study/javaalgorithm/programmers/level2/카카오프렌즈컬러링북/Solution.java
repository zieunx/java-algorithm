package com.study.javaalgorithm.programmers.level2.카카오프렌즈컬러링북;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	// 가로, 세로, 그림(0=색칠X)
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[][] movePosition = new int[][] {
			new int[] {0, 1}, // 좌
 			new int[] {0, -1}, // 우
			new int[] {1, 0}, // 상
			new int[] {-1, 0} // 하
		};

		// 로직시작

		Queue<Box> boxes = new LinkedList<>();

		int count = 0;
		boxes.add(new Box(0, 0));

		// 하나의 블럭 사이클
		while (!boxes.isEmpty()) {
			Box box = boxes.poll();
			int currentColor = picture[box.getX()][box.getY()];

			for (int[] compere : movePosition) {
				int nextX = box.getX() + compere[0];
				int nextY = box.getY() + compere[1];

				if (n <= nextX || nextX < 0 || m <= nextY || nextY < 0 || picture[nextX][nextY] == 0) {
					continue;
				}

				int targetColor = picture[nextX][nextY];
				System.out.println("current = (" + box.getX() + ", " + box.getY() + ") -> " + currentColor + " / next spot = (" + nextX + ", " + nextY + ") -> " + targetColor);

				if (currentColor == targetColor) {
					boxes.add(new Box(nextX, nextY));
					picture[box.getX()][box.getY()] = 0;
					count++;
				}
			}
		}

		numberOfArea = Math.max(count, numberOfArea);




		// 로직 끝

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}


class Box {
	private int x;
	private int y;

	public Box(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
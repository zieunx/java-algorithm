package com.study.javaalgorithm.beakjoon.새로운게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private final int[][] move = {
		{0, 1},
		{0, -1},
		{1, 0},
		{-1, 0}
	}; // 우, 좌, 상, 하
	private static final int WHITE = 0;
	private static final int RED = 1;
	private static final int BLUE = 2;

	private static final int MAX_SIZE = 4;

	public static void main(String[] args) throws IOException {
		String[] input = reader.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		// 맵 초기화
		Spot[][] map = new Spot[N][N];
		for (int i = 0; i < N; i = i + 1) {
			input = reader.readLine().split(" ");
			for (int j = 0; j < N; j = j + 1) {
				map[i][j] = new Spot(Integer.parseInt(input[j]));
			}
		}

		System.out.println("==========말 초기화");
		// 말 위치 초기화
		int x;
		int y;
		List<Horse> horses = new LinkedList<>();
		for (int i = 0; i < K; i = i + 1) {
			input = reader.readLine().split(" ");

			x = Integer.parseInt(input[0]) - 1;
			y = Integer.parseInt(input[1]) - 1;
			Horse horse = new Horse(x, y, Integer.parseInt(input[2]));

			System.out.println("입력값 = {" + x + ", " +  y + "}");

			map[x][y].add(horse);
			horses.add(horse);
		}

		System.out.println("==========");

		int turn = 0;
		while (turn <= 1001) {
			if (horses.size() == 0) {
				break;
			}
			turn = turn + 1;
			Spot nextSpot = map[0][0];
			
			// 로직
			List<Integer> removeIndexList = new ArrayList<>();
			for (int i = 0; i < horses.size(); i = i + 1) {
				Horse currentHorse = horses.get(i);
				System.out.println("currentSpot = {" + currentHorse.x + ", " +  currentHorse.y + "}");

				if (currentHorse.nextX() < 0 || currentHorse.nextX() >= N || currentHorse.nextY() < 0 || currentHorse.nextY() >= N) {
					System.out.println("범위 밖..!");
					blueRule(map, currentHorse);
				}

				Spot currentSpot = map[currentHorse.x][currentHorse.y];
				nextSpot = map[currentHorse.nextX()][currentHorse.nextY()];
				System.out.println("nextSpot = {" + currentHorse.nextX() + ", " +  currentHorse.nextY() + "}");

				if (nextSpot.color == WHITE) {
					System.out.println("WHITE!");
					whiteRule(map, currentHorse);
				} else if (nextSpot.color == RED) {
					System.out.println("RED!");
					nextSpot.addAll(currentSpot.getHorseStack());
				} else {
					System.out.println("BLUE!");
					blueRule(map, currentHorse);
				}
				if (map[currentHorse.nextX()][currentHorse.nextY()].horseSize() > 1) {
					removeIndexList.add(i);
				}

			}

			if (nextSpot.isMoreThanOrEquals(MAX_SIZE)) {
				break;
			}
			System.out.print("removeIndexList ===> ");
			removeIndexList.forEach(System.out::print);
			System.out.println();

			removeIndexList.forEach(index -> horses.remove((int) index));
			// 로직끝
		}

		System.out.println(turn == 1001 ? -1 : turn);

		reader.close();
	}

	private static void blueRule(Spot[][] map, Horse currentHorse) {
		currentHorse.reverseDirection();
		Spot nextSpot = map[currentHorse.nextX()][currentHorse.nextY()];
		if (nextSpot.color == WHITE) {
			whiteRule(map, currentHorse);
		} else if (nextSpot.color == RED) {
			// todo
		}
	}

	private static void whiteRule(Spot[][] map, Horse currentHorse) {
		// 기존스팟에서 제거
		map[currentHorse.x][currentHorse.y].remove(currentHorse);
		// 말 위치 업데이트
		currentHorse.updatePosition(currentHorse.nextX(), currentHorse.nextY());
		// 다음스팟에 추가
		map[currentHorse.nextX()][currentHorse.nextY()].add(currentHorse);
	}

	static class Spot {
		private Stack<Horse> horseStack;
		private int color;

		public Spot(int color) {
			horseStack = new Stack<>();
			this.color = color;
		}

		public void add(Horse horse) {
			horseStack.add(horse);
		}

		public int getColor() {
			return color;
		}

		public boolean isMoreThanOrEquals(int maxSize) {
			return horseStack.size() >= maxSize;
		}

		public void remove(Horse horse) {
			horseStack.remove(horse);
		}

		public Stack<Horse> getHorseStack() {
			return horseStack;
		}

		public void addAll(Stack<Horse> addHorses) {
			horseStack.addAll(addHorses);
		}

		public int horseSize() {
			return horseStack.size();
		}
	}

	static class Horse {
		private int x;
		private int y;
		private int direction;

		public Horse(int x, int y, int direction) {
			updatePosition(x, y);
			updateDirection(direction);
		}

		public void updatePosition(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int nextX() {
			if (direction == 3) {
				return x + 1;
			} else if (direction == 4) {
				return x - 1;
			} else {
				return x;
			}
		}

		public int nextY() {
			if (direction == 1) {
				return y + 1;
			} else if (direction == 2) {
				return y - 1;
			} else {
				return y;
			}
		}

		public void reverseDirection() {
			if (direction == 1) {
				direction = 2;
			} else if (direction == 2) {
				direction = 1;
			} else if (direction == 3) {
				direction = 4;
			} else if (direction == 4) {
				direction = 3;
			}
		}

		public void updateDirection(int direction) {
			this.direction = direction;
		}
	}
}

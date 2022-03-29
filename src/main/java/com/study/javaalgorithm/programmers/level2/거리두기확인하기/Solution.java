package com.study.javaalgorithm.programmers.level2.거리두기확인하기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public List<Integer> solution(String[][] places) {
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < places.length; i++) {
			// 대기실의 거리두기 확인
			answer.add(checkDistanceWaitingRoom(places[i]));
		}

		return answer;
	}

	private int checkDistanceWaitingRoom(String[] place) {
		List<Tuple> candidates = new ArrayList<>();
		char[][] waitingRoom = new char[place.length][place[0].length()];

		boolean isFollowingTheRules = true;

		// 초기화
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place[0].length(); j++) {
				waitingRoom[i][j] = place[i].charAt(j);
				if (place[i].charAt(j) == 'P') {
					candidates.add(new Tuple(i, j, 0));
				}
			}
		}

		// 응시자가 없는 경우 예외처리
		if (candidates.isEmpty()) {
			return 1;
		}
		
		for (Tuple candidate : candidates) {
			if(!isFollowingRuleBy(waitingRoom, candidate)) {
				return 0;
			}
		}

		return 1;
	}

	public boolean isFollowingRuleBy(char[][] waitingRoom, Tuple startCandidate) {
		Queue<Tuple> searchAround = new LinkedList<>(); // 상하좌우를 탐색할 대상을 넣는 Queue
		searchAround.add(startCandidate);

		while (!searchAround.isEmpty()) {
			Tuple candidate = searchAround.poll();

			for (Direction direction : Direction.values()) {
				Tuple nextCandidate = new Tuple(candidate.x + direction.x,candidate.y + direction.y, candidate.depth + 1);
				if (!nextCandidate.isInRangeBy(waitingRoom) ||
					(startCandidate.x == nextCandidate.x && startCandidate.y == nextCandidate.y)) {
					continue;
				}

				char alpha = waitingRoom[nextCandidate.x][nextCandidate.y];
				if (alpha == 'P') {
					return false;
				}
				if (nextCandidate.depth < 2 && alpha == 'O') {
					searchAround.add(nextCandidate);
				}
			}
		}
		return true;
	}

	static class Tuple {
		private final int x;
		private final int y;
		private final int depth;

		public Tuple(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		public boolean isInRangeBy(char[][] waitingRoom) {
			return 0 <= x && 0 <= y && x < waitingRoom.length && y < waitingRoom[0].length;
		}
	}

	enum Direction {
		RIGHT(0, 1),
		DOWN(-1, 0),
		LEFT(0, -1),
		UP(1, 0),
		;

		private final int x;
		private final int y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
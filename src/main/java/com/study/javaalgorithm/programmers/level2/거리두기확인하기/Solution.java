package com.study.javaalgorithm.programmers.level2.거리두기확인하기;

import java.util.ArrayList;
import java.util.List;

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
					candidates.add(new Tuple(i, j));
				}
			}
		}

		// 응시자가 없는 경우 예외처리
		if (candidates.isEmpty()) {
			return 1;
		}

		// TODO: 응시자간 거리 체크

		return 0;
	}
}

class Tuple {
	private int x;
	private int y;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
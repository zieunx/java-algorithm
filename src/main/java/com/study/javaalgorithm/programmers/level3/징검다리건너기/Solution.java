package com.study.javaalgorithm.programmers.level3.징검다리건너기;

class Solution {
	public int solution(int[] stones, int k) {
		int count = 0;

		int friendMin = 1;
		int friendMax = 200000000;
		int friendMid;

		while(friendMin <= friendMax) {
			friendMid = (friendMax + friendMin) / 2;
			if (canCrossStone(stones, k, friendMid)) {
				friendMin = friendMid + 1;
				count = Math.max(count, friendMid);
			} else {
				friendMax = friendMid - 1;
			}
		}

		return count;
	}

	public boolean canCrossStone(int[] stones, int k, int friends) {
		int zeroStoneCount = 0;

		for (int stone : stones) {
			if (stone - friends < 0) {
				zeroStoneCount++;
			} else {
				zeroStoneCount = 0;
			}
			if (k == zeroStoneCount) {
				return false;
			}
		}
		return true;
	}
}
package com.study.javaalgorithm.programmers.level2.멀쩡한사각형;

public class Solution {
	public long solution(int w, int h) {

		int min = Math.min(w, h);
		int max = Math.max(w, h);
		long gcd = calculateGreatestCommonFactor(max, min);

		System.out.println("gcd = " + gcd);
		long minW = (long)w / (long)gcd;
		long minH = (long)h / (long)gcd;


		long sliceSquareCount = minW + minH - 1;


		return (long)w * (long)h - (long)(sliceSquareCount * gcd);
	}

	public long calculateGreatestCommonFactor(long w, long h) {
		if((long)w % (long)h == 0) {
			return h;
		}
		return calculateGreatestCommonFactor(w, (long)w % (long)h);
	}
}

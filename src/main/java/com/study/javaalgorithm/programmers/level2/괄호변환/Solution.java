package com.study.javaalgorithm.programmers.level2.괄호변환;

import java.util.Stack;

public class Solution {
	Stack<Character> checkStack = new Stack<>();

	public String solution(String p) {

		if (p.length() == 0) {
			return p;
		}

		return changeRight(p);
	}

	public String changeRight(String brackets) {
		if (brackets.length() == 0) {
			return brackets;
		}
		int uIndex = findUEndIndex(brackets);

		String u = brackets.substring(0, uIndex + 1);
		String v = brackets.substring(uIndex + 1);

		if (isRight(u)) {
			return u + changeRight(v);
		}

		return createU(u, v);
	}

	private String createU(String u, String v) {
		return "(" + changeRight(v) + ")" + toggleBuckets(u.substring(1, u.length() - 1));
	}

	private String toggleBuckets(String buckets) {
		StringBuilder replaceBuckets = new StringBuilder();
		for(int i = 0; i < buckets.length(); i++) {
			replaceBuckets.append(buckets.charAt(i) == '(' ? ')' : '(');
		}
		return replaceBuckets.toString();
	}

	public int findUEndIndex(String buckets) {
		char startBucket = buckets.charAt(0);
		int count = 0;
		for (int i = 0; i < buckets.length(); i++) {
			if (startBucket == buckets.charAt(i)) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				return i;
			}
		}

		return 0;
	}

	public boolean isRight(String text) {
		checkStack.clear();

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == '(') {
				checkStack.add(c);
			} else {
				if (checkStack.isEmpty()) {
					return false;
				}
				checkStack.pop();
			}
		}

		return checkStack.isEmpty();
	}
}

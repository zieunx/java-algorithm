package com.study.javaalgorithm.programmers.level2.괄호변환;

import java.util.Stack;

public class Solution {
	Stack<Character> checkStack = new Stack<>();

	public String solution(String p) {

		if (p.length() == 0) {
			return p;
		}

		return balanceToRight(p);
	}

	public String balanceToRight(String text) {
		if (text.length() == 0) {
			return text;
		}
		int uIndex = findUEndIndex(text);

		String u = text.substring(0, uIndex + 1);
		String v = text.substring(uIndex + 1);

		if (isRight(u)) {
			return u + balanceToRight(v);
		}

		return changeU(u, balanceToRight(v));
	}

	private String changeU(String u, String alrightV) {
		return "(" + alrightV + ")" + changeWrap(u.substring(1, u.length() - 1));
	}

	private String changeWrap(String parentheses) {
		StringBuilder replaceParentheses = new StringBuilder();
		for(int i = 0; i < parentheses.length(); i++) {
			replaceParentheses.append(parentheses.charAt(i) == '(' ? ')' : '(');
		}
		return replaceParentheses.toString();
	}

	public int findUEndIndex(String text) {
		char startChar = text.charAt(0);
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (startChar == text.charAt(i)) {
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

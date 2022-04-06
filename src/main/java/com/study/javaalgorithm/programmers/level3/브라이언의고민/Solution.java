package com.study.javaalgorithm.programmers.level3.브라이언의고민;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
	public String solution(String sentence) {
		if (followRule(sentence)) {
			return "invalid";
		}

		// TODO

		String answer = "";
		return answer;
	}

	private boolean followRule(String sentence) {
		if (sentence.contains(" ")) {
			return false;
		}
		return true;
	}

	class Marks {
		private Set<Character> duplicateCheck;
		private Stack<Character> brackets;
		private Character beforeCharacter;

		public Marks() {
			this.duplicateCheck = new HashSet<>();
			this.brackets = new Stack<>();
			this.beforeCharacter = null;
		}

		public void add(char character) {
			if (beforeCharacter == null) {
				if (Character.isLowerCase(character)) {
					brackets.push(character);
				} else {
					// 대문자는 패스!
				}
				return;
			}
			if (Character.isLowerCase(beforeCharacter) || Character.isLowerCase(character)) {
				// 전=소문자, 현=소문자
				brackets.push(character);
			} else if (Character.isUpperCase(beforeCharacter) || Character.isLowerCase(character)) {
				// 전=대문자, 현=소문자
				brackets.push(character);
			} else if (Character.isLowerCase(beforeCharacter) || Character.isUpperCase(character)) {
				// 전=소문자, 현=대문자
			} else if (Character.isUpperCase(beforeCharacter) || Character.isUpperCase(character)) {
				// 전=대문자, 현=대문자
			}
		}
	}
}

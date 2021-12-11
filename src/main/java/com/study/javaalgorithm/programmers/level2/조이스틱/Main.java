package com.study.javaalgorithm.programmers.level2.조이스틱;

public class Main {
	public static void main(String[] args) {
		char[] alphabet = new char[26];

		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) (i + 65);
		}

		for (int i = 0; i < alphabet.length; i++) {
			System.out.println(alphabet[i]);
		}
	}
}

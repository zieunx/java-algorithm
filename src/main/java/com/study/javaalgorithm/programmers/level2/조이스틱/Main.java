package com.study.javaalgorithm.programmers.level2.조이스틱;

public class Main {
	public static void main(String[] args) {
		// char[] alphabet = new char[26];
		//
		// for (int i = 0; i < alphabet.length; i++) {
		// 	alphabet[i] = (char) (i + 65);
		// }
		//
		// for (int i = 0; i < alphabet.length; i++) {
		// 	System.out.println(alphabet[i]);
		// }

		String name = "JEROEN";
		StringBuilder targetName = new StringBuilder();
		int move = 0;
		char currentAlphabet;

		for (int i = 0; i < name.length(); i++) {
			targetName.append("A");
		}

		for (int i = 0; i < name.length(); i++) {
			if ((int) name.charAt(i) == (int) 'A') {
				continue;
			}
			currentAlphabet = name.charAt(i);

			int countFromA = Math.abs((int) 'A' - (int) currentAlphabet);
			int countFromZ = Math.abs((int) 'Z' - (int) currentAlphabet);

			move += Math.min(countFromA, countFromZ);
		}

		System.out.println("result = " + move);

		// 현재(currentIndex)에서 targetIndex 사이의 간격? (targetIndex - currentIndex)
		// 간격이 반 이상일 때 (가운데 인덱스 확ㅇ니 필요 \)
		// 현재(currentIndex)에서 targetIndex 사이의 간격? (targetIndex - currentIndex)
		// 현재(currentIndex)에서 앞으로 몇번째인지? (targetIndex - currentIndex)

		// 첫번째(A)에서 뒤로 몇번째인지? size - targetIndex = A에서 뒤로 N번째 이동
		// 첫번째(A)에서 앞으로 몇번째인지? targetIndex = A에서 앞으로 N번째 이동
		// a b c d e f g h / i j k  l  m  n  o  p
		// 0 1 2 3 4 5 6 7 / 8 9 10 11 12 13 14 15
	}
}

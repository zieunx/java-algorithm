package com.study.javaalgorithm.programmers.level3.브라이언의고민;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
	@Test
	void addTest() {
		Solution.Marks marks = new Solution.Marks();
		String sentence = "HaEaLaLaObWORLDb";

		for (int i =0; i < sentence.length(); i++) {
			marks.add(sentence.charAt(i));
		}

		assertThat(marks.getBrackets().toArray())
			.containsExactly('a', 'a', 'a', 'a', 'b', 'b');
	}

	@Test
	void 정답이_여러개인_문장() {
		Solution.Marks marks = new Solution.Marks();
		String sentence = "SpIpGpOpNpGJqOqA";

		for (int i =0; i < sentence.length(); i++) {
			marks.add(sentence.charAt(i));
		}

		assertThat(marks.getBrackets().toArray())
			.containsExactly('p', 'p', 'p', 'p', 'p', 'q', 'q');
	}
}
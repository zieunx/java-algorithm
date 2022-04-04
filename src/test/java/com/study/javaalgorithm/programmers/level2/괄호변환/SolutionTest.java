package com.study.javaalgorithm.programmers.level2.괄호변환;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

	@Test
	void subStringTest() {
		String text = "()))((()";

		assertThat(text.substring(0, 2)).isEqualTo("()");
		assertThat(text.substring(2)).isEqualTo("))((()");
	}

	@Test
	void subStringCropFrontAndBackTest() {
		String text = "()))((()";

		assertThat(text.substring(1, text.length() - 1)).isEqualTo(")))(((");
	}

	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private String p;
			private String result;

			public TestCase(String p, String result) {
				this.p = p;
				this.result = result;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			// new TestCase("(()())()", "(()())()"),
			// new TestCase("()))((()", "()(())()"),
			// new TestCase(")(", "()"),
			// new TestCase("", ""),
			new TestCase("))))((((", "()((()))"),
			new TestCase(")()(()", "((()))")
		).map(
			it -> DynamicTest.dynamicTest(
				"괄호변환 Solution",
				() -> assertThat(solution.solution(it.p)).isEqualTo(it.result)
			)
		);
	}
}
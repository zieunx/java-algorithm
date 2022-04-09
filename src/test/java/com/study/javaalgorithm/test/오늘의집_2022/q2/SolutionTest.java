package com.study.javaalgorithm.test.오늘의집_2022.q2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private String call;
			private String result;

			public TestCase(String call, String result) {
				this.call = call;
				this.result = result;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			new TestCase("abcabcdefabc", "def")
		).map(
			it -> DynamicTest.dynamicTest(
				"q2 solution",
				() -> assertThat(solution.solution(it.call)).isEqualTo(it.result)
			)
		);
	}
}
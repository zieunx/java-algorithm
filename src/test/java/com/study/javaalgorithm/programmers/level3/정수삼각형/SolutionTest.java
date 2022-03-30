package com.study.javaalgorithm.programmers.level3.정수삼각형;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private int[][] triangle;
			private int result;

			public TestCase(int[][] triangle, int result) {
				this.triangle = triangle;
				this.result = result;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			new TestCase(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}, 30)
		).map(
			it -> DynamicTest.dynamicTest(
				"정수삼각형 solution",
				() -> assertThat(solution.solution(it.triangle)).isEqualTo(it.result)
			)
		);
	}
}
package com.study.javaalgorithm.programmers.level3.자물쇠와열쇠;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private int[][] key;
			private int[][] lock;
			private boolean result;

			public TestCase(int[][] key, int[][] lock, boolean result) {
				this.key = key;
				this.lock = lock;
				this.result = result;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			new TestCase(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, true),
			new TestCase(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, false),
			new TestCase(new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, true)
		).map(
			it -> DynamicTest.dynamicTest(
				"자물쇠와열쇠 solution",
				() -> assertThat(solution.solution(it.key, it.lock)).isEqualTo(it.result)
			)
		);
	}
}
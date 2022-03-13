package com.study.javaalgorithm.programmers.level3.모두0으로만들기;


import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {

		class TestCase {
			private int[] a;
			private int[][] adges;
			private int expected;

			public TestCase(int[] a, int[][] adges, int expected) {
				this.a = a;
				this.adges = adges;
				this.expected = expected;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			new TestCase(new int[] {-5,0,2,1,2}, new int[][] {{0,1},{3,4},{2,3},{0,3}}, 9),
			new TestCase(new int[] {0,1,0}, new int[][] {{0,1},{1,2}}, -1)
		).map(
			it -> DynamicTest.dynamicTest("solution",
				() -> assertThat(solution.solution(it.a, it.adges)).isEqualTo(it.expected))
		);
	}
}
package com.study.javaalgorithm.test.t0312.q4;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {

		class TestCase {
			private final int n;
			private final int[][] edges;
			private final int expected;

			public TestCase(int n, int[][] edges, int expected) {
				this.n = n;
				this.edges = edges;
				this.expected = expected;
			}
		}
		final Solution solution = new Solution();

		return Stream.of(
			new TestCase(5, new int[][] {{0,1},{0,2},{1,3},{1,4}}, 16)
			, new TestCase(4, new int[][] {{2,3},{0,1},{1,2}}, 8)
		).map(
			it ->  DynamicTest.dynamicTest("solution",
				() -> assertThat(solution.solution(it.n, it.edges)).isEqualTo(it.expected))
		);
	}
}
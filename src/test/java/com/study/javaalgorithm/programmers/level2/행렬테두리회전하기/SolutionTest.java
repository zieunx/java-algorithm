package com.study.javaalgorithm.programmers.level2.행렬테두리회전하기;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

	@TestFactory
	Stream<DynamicTest> solution() {

		class TestCase {
			private int rows;
			private int columns;
			private int[][] queries;
			private int[] expected;

			public TestCase(int rows, int columns, int[][] queries, int[] expected) {
				this.rows = rows;
				this.columns = columns;
				this.queries = queries;
				this.expected = expected;
			}
		}

		final Solution solution = new Solution();
		return Stream.of(
			new TestCase(6,6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}}, new int[] {8, 10, 25})
			,
			new TestCase(3,3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}, new int[] {1, 1, 5, 3})
		).map(
			it -> DynamicTest.dynamicTest(
				"행렬테두리회전하기 solution",
				() -> assertThat(solution.solution(it.rows, it.columns, it.queries)).isEqualTo(it.expected)
			)
		);
	}
}
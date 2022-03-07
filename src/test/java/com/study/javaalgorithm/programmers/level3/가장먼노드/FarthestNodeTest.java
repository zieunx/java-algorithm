package com.study.javaalgorithm.programmers.level3.가장먼노드;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class FarthestNodeTest {
	@TestFactory
	Stream<DynamicTest> solution() {

		class TestCase {
			private final int n;
			private final int[][] edge;
			private final int expected;

			public TestCase(int n, int[][] edge, int expected) {
				this.n = n;
				this.edge = edge;
				this.expected = expected;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			new TestCase(6, new int[][] { new int[] {3, 6}, new int[] {4, 3}, new int[] {3, 2}, new int[] {1, 2}, new int[] {2, 4}, new int[] {5, 2}}, 3)
		).map(
			it -> DynamicTest.dynamicTest("solution",
				() -> assertThat(solution.solution(it.n, it.edge)).isEqualTo(it.expected))
		);
	}
}

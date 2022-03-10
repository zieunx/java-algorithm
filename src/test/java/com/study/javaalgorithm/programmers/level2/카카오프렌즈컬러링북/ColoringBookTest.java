package com.study.javaalgorithm.programmers.level2.카카오프렌즈컬러링북;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class ColoringBookTest {
	@TestFactory
	Stream<DynamicTest> solution() {

		class TestCase {
			private int m;
			private int n;
			private int[][] picture;
			private int[] expected;

			public TestCase(int m, int n, int[][] picture, int[] expected) {
				this.m = m;
				this.n = n;
				this.picture = picture;
				this.expected = expected;
			}
		}

		final Solution solution = new Solution();


		return Stream.of(
			new TestCase(6, 4, new int[][]{new int[]{1, 1, 1, 0}, new int[]{1, 2, 2, 0}, new int[]{1, 0, 0, 1}, new int[]{0, 0, 0, 1}, new int[]{0, 0, 0, 3}, new int []{0, 0, 0, 3}}, new int[] {4, 5})
		).map(
			it -> DynamicTest.dynamicTest(
				"solution",
				() -> assertThat(solution.solution(it.m, it.n, it.picture)).isEqualTo(it.expected)
			)
		);
	}
}

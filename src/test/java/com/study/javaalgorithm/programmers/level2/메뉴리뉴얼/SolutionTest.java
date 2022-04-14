package com.study.javaalgorithm.programmers.level2.메뉴리뉴얼;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private String[] orders;
			private int[] course;
			private String[] result;

			public TestCase(String[] orders, int[] course, String[] result) {
				this.orders = orders;
				this.course = course;
				this.result = result;
			}
		}
		final Solution solution = new Solution();

		return Stream.of(
			// new TestCase(
			// 	new String[] { "XYZ", "XWY", "WXA" },
			// 	new int[] { 2, 3, 4 },
			// 	new String[] { "WX", "XY" }
			// ),
			new TestCase(
				new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" },
				new int[] { 2, 3, 5 },
				new String[] { "ACD", "AD", "ADE", "CD", "XYZ" }
			)
		).map(
			it -> DynamicTest.dynamicTest(
				"메뉴 리뉴얼 Solution",
				() -> assertThat(solution.solution(it.orders, it.course)).isEqualTo(it.result)
			)
		);
	}
}
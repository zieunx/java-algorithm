package com.study.javaalgorithm.programmers.level2.거리두기확인하기;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private String[][] places;
			private List<Integer> result;

			public TestCase(String[][] places, List<Integer> result) {
				this.places = places;
				this.result = result;
			}
		}
		final Solution solution = new Solution();
		return Stream.of(
			new TestCase(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}}, Arrays.stream(new int[] {1}).boxed().collect(Collectors.toList()))
		).map(
			it -> DynamicTest.dynamicTest(
				"거리두기확인하기 solution",
				() -> assertThat(solution.solution(it.places)).isEqualTo(it.result)
			)
		);
	}
}
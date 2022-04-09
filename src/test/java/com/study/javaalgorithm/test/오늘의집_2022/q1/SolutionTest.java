package com.study.javaalgorithm.test.오늘의집_2022.q1;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private String road;
			private List<String> result;

			public TestCase(String road, List<String> result) {
				this.road = road;
				this.result = result;
			}
		}

		final Solution solution = new Solution();

		List<String> results = new ArrayList<>();
		results.add("Time 0: Go straight 300m and turn right");
		results.add("Time 3: Go straight 100m and turn left");
		results.add("Time 5: Go straight 500m and turn left");

		List<String> results2 = new ArrayList<>();
		results2.add("Time 1: Go straight 500m and turn right");
		results2.add("Time 6: Go straight 300m and turn right");

		return Stream.of(
			new TestCase("EEESEEEEEENNNN", results),
			new TestCase("SSSSSSWWWNNNNNN", results2)
		).map(
			it -> DynamicTest.dynamicTest(
				"q1 solution",
				() -> assertThat(solution.solution(it.road)).isEqualTo(it.result) //
			)
		);
	}
}
package com.study.javaalgorithm.programmers.level3.양과늑대;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {
//	@TestFactory
//	Stream<DynamicTest> solution() {
//		class TestCase {
//			int[] info;
//			int[][] edges;
//			private int expected;
//
//			public TestCase(int[] info, int[][] adges, int expected) {
//				this.info = info;
//				this.edges = adges;
//				this.expected = expected;
//			}
//		}
//
//		final Solution solution = new Solution();
//
//		return Stream.of(
//			new TestCase(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}, 5)
//			// ,
//			// new TestCase(new int[] {0,1,0,1,1,0,1,0,0,1,0}, new int[][] {{0,1},{1,2}}, -1)
//		).map(
//			it -> DynamicTest.dynamicTest("solution",
//				() -> assertThat(solution.solution(it.info, it.edges)).isEqualTo(it.expected))
//		);
//	}
}
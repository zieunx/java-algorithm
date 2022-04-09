package com.study.javaalgorithm.test.오늘의집_2022.q3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

	@Test
	void changeVariableTest() {
		String text = "{a} {b} {c} {d} {i}";

		assertThat(Solution.changeVariable(text, "{b}", "{c}")).isEqualTo("{a} {c} {c} {d} {i}");
		// assertThat(Solution.changeVariable(text, "{test}", "zz")).isEqualTo("zz is zz {ss} zz");
	}

	@TestFactory
	Stream<DynamicTest> solution() {
		class TestCase {
			private String tstring;
			private String[][] variables;
			private String result;

			public TestCase(String tstring, String[][] variables, String result) {
				this.tstring = tstring;
				this.variables = variables;
				this.result = result;
			}
		}

		final Solution solution = new Solution();

		return Stream.of(
			// new TestCase("this is {template} {template} is {state}", new String[][] {
			// 	{"template", "string"},
			// 	{"state", "changed"}
			// }, "this is string string is changed"),
			// new TestCase("this is {template} {template} is {state}", new String[][] {
			// 	{"template", "string"},
			// 	{"state", "{template}"}
			// }, "this is string string is string"),
			// new TestCase("this is {template} {template} is {state}", new String[][] {
			// 	{"template", "{state}"},
			// 	{"state", "{template}"}
			// }, "this is {template} {template} is {state}"),
			// new TestCase("this is {template} {template} is {state}", new String[][] {
			// 	{"template", "{state}"},
			// 	{"state", "{templates}"}
			// }, "this is {template} {template} is {templates}")
			new TestCase("{b} {c} {d} {d} {i}", new String[][] {
				{"b", "{c}"},
				{"a", "{b}"},
				{"e", "{f}"},
				{"h", "i"},
				{"d", "{e}"},
				{"f", "{d}"},
				{"c", "d"}
			}, "d d d {d} {i}")
		).map(
			it -> DynamicTest.dynamicTest(
				"q3 solution",
				() -> assertThat(solution.solution(it.tstring, it.variables)).isEqualTo(it.result) //
			)
		);
	}
}
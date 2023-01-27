package com.study.javaalgorithm.test.b;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Test1Test {
    @Test
    void run() {
        // given
        Test1 test = new Test1();
        String input = "+2 11 =4 13 25";
        String expected = "1 + 1 = 2";

        // when
        String result = test.solution(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
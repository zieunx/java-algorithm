package com.study.javaalgorithm.programmers.level2.캐시;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheTest {


    @TestFactory
    Stream<DynamicTest> solution() {

        class TestCase {
            private int cacheSize;
            private String[] cities;
            private int expected;

            public TestCase(int cacheSize, String[] cities, int expected) {
                this.cacheSize = cacheSize;
                this.cities = cities;
                this.expected = expected;
            }
        }

        final Solution solution = new Solution();

        return Stream.of(
            new TestCase(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 50)
            , new TestCase(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 21)
            , new TestCase(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 60)
            , new TestCase(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 52)
            , new TestCase(16, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}, 16)
            , new TestCase(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 25)
            , new TestCase(1, new String[] {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"}, 12)
            , new TestCase(10, new String[] {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"}, 12)
            , new TestCase(0, new String[] {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"}, 40)
        ).map(
                it -> DynamicTest.dynamicTest(
                        "캐시 solution",
                        () -> assertThat(solution.solution(it.cacheSize, it.cities)).isEqualTo(it.expected)
                )
        );
    }
}

package com.study.javaalgorithm.programmers.level1.모의고사;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("result = " + Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println("result = " + Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        List<Integer> results = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, initQueue(1, 2, 3, 4, 5)));
        students.add(new Student(2, initQueue(2, 1, 2, 3, 2, 4, 2, 5)));
        students.add(new Student(3, initQueue(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)));

        // 학생들이 점수를 맞췄는지 확인
        int max = 0;
        for (int answer : answers) {
            for (Student student : students) {
                student.score(answer);
                if (student.isMoreThan(max)) {
                    max = student.getScore();
                }
                student.next();
            }
        }

        // 최고점에 해당하는 학생 추리기
        for (Student student : students) {
            if (student.equalsScore(max)) {
                results.add(student.getId());
            }
        }

        // List to Array
        int[] resultArr = new int[results.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = results.get(i);
        }

        return resultArr;
    }

    public static Queue<Integer> initQueue(int ... values) {
        Queue<Integer> collection = new LinkedList<>();
        for (int value : values) {
            collection.add(value);
        }

        return collection;
    }

    static class Student {
        private Integer id;
        private Queue<Integer> rules;
        private int score;

        public Student(Integer id, Queue<Integer> rules) {
            this.id = id;
            this.rules = rules;
        }

        public Integer next() {
            Integer n = rules.poll();
            rules.add(n);
            return n;
        }

        public void score(int answer) {
            if (rules.peek() == answer) {
                score += 1;
            }
        }

        public int getScore() {
            return score;
        }

        public boolean isMoreThan(int max) {
            return score > max;
        }

        public Integer getId() {
            return id;
        }

        public boolean equalsScore(int max) {
            return score == max;
        }
    }
}

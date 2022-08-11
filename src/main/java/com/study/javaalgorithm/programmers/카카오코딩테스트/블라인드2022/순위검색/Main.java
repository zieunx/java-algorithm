package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2022.순위검색;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final Set<Integer> ALL_INDEX = new HashSet<>();
    public static Language language = new Language();
    public static JobGroup jobGroup = new JobGroup();
    public static Career career = new Career();
    public static Food food = new Food();
    public static Score score = new Score();

    /*
    나의 접근
    query -> " "으로 잘라서 0,2,4,6 배열로 조건찾기, 마지막배열 = 점수
     */
    public static void main(String[] args) {
        int[] result = solution(
                new String[] {
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"
                },
                new String[] {
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"
                }
        );

        System.out.println("[결과]");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // info 로 데이터 초기화
        for (int index = 0; index < info.length; index++) {
            ALL_INDEX.add(index);

            String[] person = info[index].split(" ");
            language.addIndex(person[0], index);
            jobGroup.addIndex(person[1], index);
            career.addIndex(person[2], index);
            food.addIndex(person[3], index);
            score.add(Integer.parseInt(person[4]));
        }

        // query 탐색
        for (int i = 0; i < query.length; i++) {
            String[] singleQuery = query[i].split(" ");

            answer[i] = score.count(food.result(
                    singleQuery[6],
                    career.result(
                            singleQuery[4],
                            jobGroup.result(
                                    singleQuery[2],
                                    language.result(singleQuery[0])
                            )
                    )
            ), Integer.parseInt(singleQuery[singleQuery.length - 1]));
        }

        return answer;
    }

    public static class Language {
        private Set<Integer> cpp = new LinkedHashSet<>();
        private Set<Integer> java = new LinkedHashSet<>();
        private Set<Integer> python = new LinkedHashSet<>();
        private Set<Integer> EMPTY = new LinkedHashSet<>();

        public void addIndex(String language, int index) {
            if (language.equals("cpp")) {
                cpp.add(index);
            } else if (language.equals("java")) {
                java.add(index);
            } else if (language.equals("python")) {
                python.add(index);
            }
        }

        public Set<Integer> result(String language) {
            if (language.equals("-")) {
                return ALL_INDEX;
            }

            if (language.equals("cpp")) {
                return cpp;
            } else if (language.equals("java")) {
                return java;
            } else if (language.equals("python")) {
                return python;
            }
            return EMPTY;
        }

        @Override
        public String toString() {
            return "Language {" + "\n" +
                    "cpp=" + cpp + "\n" +
                    ", java=" + java + "\n" +
                    ", python=" + python + "\n" +
                    ", EMPTY=" + EMPTY + "\n" +
                    '}';
        }
    }

    public static class JobGroup {
        private Set<Integer> backend = new LinkedHashSet<>();
        private Set<Integer> frontend = new LinkedHashSet<>();

        public void addIndex(String value, int index) {
            if (value.equals("backend")) {
                backend.add(index);
            } else {
                frontend.add(index);
            }
        }

        public Set<Integer> result(String value, Set<Integer> filterIndexGroup) {
            if (value.equals("-")) {
                return filterIndexGroup;
            } if (value.equals("backend")) {
                return filterIndexGroup.stream()
                        .filter(index -> backend.contains(index))
                        .collect(Collectors.toSet());
            } else {
                return filterIndexGroup.stream()
                        .filter(index -> frontend.contains(index))
                        .collect(Collectors.toSet());
            }
        }

        @Override
        public String toString() {
            return "JobGroup{ " + "\n" +
                    "backend=" + backend + "\n" +
                    ", frontend=" + frontend + "\n" +
                    '}';
        }
    }

    public static class Career {
        private Set<Integer> junior = new LinkedHashSet<>();
        private Set<Integer> senior = new LinkedHashSet<>();

        public void addIndex(String value, int index) {
            if (value.equals("junior")) {
                junior.add(index);
            } else {
                senior.add(index);
            }
        }

        public Set<Integer> result(String value, Set<Integer> filterIndexGroup) {
            if (value.equals("-")) {
                return filterIndexGroup;
            } if (value.equals("junior")) {
                return filterIndexGroup.stream()
                        .filter(index -> junior.contains(index))
                        .collect(Collectors.toSet());
            } else {
                return filterIndexGroup.stream()
                        .filter(index -> senior.contains(index))
                        .collect(Collectors.toSet());
            }
        }

        @Override
        public String toString() {
            return "Career{" + "\n" +
                    "junior=" + junior + "\n" +
                    ", senior=" + senior + "\n" +
                    '}';
        }
    }

    public static class Food {
        private Set<Integer> chicken = new LinkedHashSet<>();
        private Set<Integer> pizza = new LinkedHashSet<>();

        public void addIndex(String value, int index) {
            if (value.equals("chicken")) {
                chicken.add(index);
            } else {
                pizza.add(index);
            }
        }

        public Set<Integer> result(String value, Set<Integer> filterIndexGroup) {
            if (value.equals("-")) {
                return filterIndexGroup;
            } if (value.equals("chicken")) {
                return filterIndexGroup.stream()
                        .filter(index -> chicken.contains(index))
                        .collect(Collectors.toSet());
            } else {
                return filterIndexGroup.stream()
                        .filter(index -> pizza.contains(index))
                        .collect(Collectors.toSet());
            }
        }

        @Override
        public String toString() {
            return "Food{" + "\n" +
                    "chicken=" + chicken + "\n" +
                    ", pizza=" + pizza + "\n" +
                    '}';
        }
    }

    public static class Score {
        private List<Integer> allScores = new ArrayList<>();

        public void add(int score) {
            allScores.add(score);
        }

        public int count(Set<Integer> filterIndexs, int score) {
            int count = 0;

            for (Integer index : filterIndexs) {
                if (allScores.get(index) >= score) {
                    count = count + 1;
                }
            }

            return count;
        }

        @Override
        public String toString() {
            return "Score{" + "\n" +
                    "allScores=" + allScores + "\n" +
                    '}';
        }
    }
}

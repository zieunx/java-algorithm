package com.study.javaalgorithm.programmers.level3.단어변환;

public class Solution {
    public static void main(String[] args) {

        Test test = new Test();

        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//        String[] words = { "hot", "dot", "dog", "lot", "log" };

        System.out.println("result = " + test.solution(begin,target,words));
    }

    static class Test {
        public int solution(String begin, String target, String[] words) {
            int min = 0;

            for (int i = 0; i < words.length; i++) {
                // 비긴과 한글자 차이나는 단어들을 dfs 시작
                boolean check = canChangeWord(begin, words[i]);
                System.out.printf("%s %s -> %b\n", begin, words[i], check);
                if (canChangeWord(begin, words[i])) {
                    boolean[] visited = new boolean[words.length];
                    visited[i] = true;

                    int result = bfs(words[i], target, words, visited, 1);

                    System.out.println("결과: " + result);
                    if (min == 0) {
                        min = result;
                    } else {
                        min = Math.min(result, min);
                    }
                }
            }

            return min;
        }

        private boolean canChangeWord(String begin, String word) {
            int diffCount = 0;
            for (int i = 0; i < begin.length(); i++) {
//                System.out.printf("  %c != %c ? %b\n", begin.charAt(i), word.charAt(i), begin.charAt(i) != word.charAt(i));
                if (begin.charAt(i) != word.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
            }
            return diffCount == 1;
        }

        private int bfs(String currentWord, String target, String[] words, boolean[] visited, int count) {
            System.out.printf("currentWord: %s , count: %d\n", currentWord, count);
            if (target.equals(currentWord)) {
                System.out.println(" ----> return!");
                return count;
            } else if (count == words.length) {
                return 0;
            }

            int min = 0;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChangeWord(currentWord, words[i])) {
                    visited[i] = true;
                    int result = bfs(words[i], target, words, visited, count + 1);
                    if (min == 0) {
                        min = result;
                    } else {
                        min = Math.min(min, result);
                    }
                    visited[i] = false;
                }
            }

            return min;
        }
    }
}

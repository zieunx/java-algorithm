package com.study.javaalgorithm.programmers.level3.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Test test = new Test();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println("result: " + Arrays.toString(test.solution(genres, plays)));
    }

    static class Test {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, List<Music>> groupByGenres = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (groupByGenres.containsKey(genres[i])) {
                    groupByGenres.get(genres[i]).add(new Music(i, genres[i], plays[i]));
                } else {
                    List<Music> list = new ArrayList<>();
                    list.add(new Music(i, genres[i], plays[i]));
                    groupByGenres.put(genres[i], list);
                }
            }
            List<String> genreSorted = groupByGenres.keySet().stream()
                    .sorted(Comparator.comparing(v -> groupByGenres.get(v).stream().mapToInt(Music::getPlay).sum()).reversed())
                    .collect(Collectors.toList());

            List<Integer> answer = new ArrayList<>();

            for (String genre : genreSorted) {
                List<Music> music = groupByGenres.get(genre);
                if (music.size() == 0) {
                    continue;
                } else if (music.size() == 1) {
                    answer.add(music.get(0).getId());
                } else {
                    music.sort(Comparator.comparing(Music::getPlay).reversed());
                    answer.add(music.get(0).getId());
                    answer.add(music.get(1).getId());
                }
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }

    static class Music {
        private int id;
        private String genre;
        private int play;

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        public int getPlay() {
            return play;
        }

        public Integer getId() {
            return id;
        }
    }
}

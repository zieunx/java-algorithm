package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2022.신고결과받기;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("테스트~~");
        System.out.println(new User("테스트").equals(new User("테스트")));

        System.out.println("==============================================");

        int[] solution = solution(
                new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        );

//        int[] solution = solution(
//                new String[] {"con", "ryan"},
//                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"},
//                3
//        );

        System.out.println("[결과]");
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<User, Set<User>> declaration = new LinkedHashMap<>(); // 신고당한유저, 신고한사람목록

        // 사용자 초기화
        for (String value : id_list) {
            declaration.put(new User(value), new HashSet<>());
        }

        // 리포트를 기반으로 신고 내용 정리
        for (String s : report) {
            User reporter = new User(s.split(" ")[0]); // 신고자
            User user = declaration.keySet().stream().filter(deUser -> deUser.equals(reporter)).findFirst().get();
            User reported = new User(s.split(" ")[1]); // 신고당한사람
            // 유저의 신고자 업데이트
            user.addDeclarationUser(reported);
            // 신고정보 업데이트
            declaration.get(reported).add(user);
        }

        List<User> targetUsers = declaration.keySet().stream()
                .filter(declarationUser -> declaration.get(declarationUser).size() >= k)
                .collect(Collectors.toList());

        List<User> userList = new ArrayList<>(declaration.keySet());
        for (int i = 0; i < userList.size(); i++) {
            answer[i] = userList.get(i).countUser(targetUsers);
        }

        return answer;
    }

    public static class User {
        private String name;
        private final Set<User> declration = new HashSet<>();

        public User(String name) {
            this.name = name;
        }

        public void addDeclarationUser(User user) {
            declration.add(user);
        }

        public int countUser(List<User> targetUsers) {
            return (int) declration.stream()
                    .filter(targetUsers::contains)
                    .count();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}

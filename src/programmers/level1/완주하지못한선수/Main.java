package programmers.level1.완주하지못한선수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 - 완주하지 못한 선수
 * url : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Main {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    // participant 참여 선수들 1<= n <= 100,000
    // completion 완주한 선수들 n - 1
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> participantList = new ArrayList<>(Arrays.asList(participant))
                .stream().sorted().collect(Collectors.toList());
        List<String> completionList = new ArrayList<>(Arrays.asList(completion))
                .stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < completionList.size(); i++) {
            if (!participantList.get(i).equals(completionList.get(i))) {
                answer = participantList.get(i);
                break;
            }
        }

        return answer.equals("")
                ? participantList.get(participantList.size() - 1)
                : answer;
    }
}

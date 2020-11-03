package programmers.level1.두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

    }

    static int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length ; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && !answer.contains(numbers[i] + numbers[j])) {
                    answer.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] answerArr = answer.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(answerArr);
        return answerArr;
    }
}

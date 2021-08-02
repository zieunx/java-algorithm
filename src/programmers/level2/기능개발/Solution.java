package programmers.level2.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] progresses = {85, 88, 87};
        int[] speeds = {1, 1, 1};

        int[] solution = solution(progresses, speeds);

        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Stack<Integer> deploymentStack = new Stack<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = 100 - progresses[i];
            int remainDays = (int) Math.ceil((double) progress / (double) speeds[i]);

            if (deploymentStack.isEmpty()) {
                deploymentStack.add(remainDays);
            } else if (deploymentStack.peek() >= remainDays) {
                deploymentStack.add(deploymentStack.peek());
            } else if (deploymentStack.peek() < remainDays) {
                answerList.add(deploymentStack.size());
                deploymentStack.clear();
                deploymentStack.add(remainDays);
            }
        }

        if (!deploymentStack.isEmpty()) {
            answerList.add(deploymentStack.size());
            deploymentStack.clear();
        }

        int[] answers = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answers[i] = answerList.get(i);
        }

        return answers;
    }
}

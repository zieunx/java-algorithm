package programmers.level2.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Integer[] solution = solution(progresses, speeds);

        Arrays.stream(solution).forEach(System.out::println);
    }
    public static Integer[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Stack<Integer> deploymentStack = new Stack<>();

        int frontIssueDays = (100 - progresses[0]) / speeds[0];
        deploymentStack.add(frontIssueDays);

        for(int i = 1; i < progresses.length; i ++) {
            int currentIssueDays = (100 - progresses[i]) / speeds[i];
            if (frontIssueDays < currentIssueDays) {
                answerList.add(deploymentStack.size());
                deploymentStack.clear();
            }
            System.out.println(progresses[i] + "=>      " + "front : {" + frontIssueDays + "} / current : {" + currentIssueDays + "} = " + (frontIssueDays >= currentIssueDays) + " [stack] = " + deploymentStack);
            frontIssueDays = currentIssueDays;
            deploymentStack.add(frontIssueDays);
        }

        return answerList.toArray(Integer[]::new);
    }
}

package programmers.level3.단속카메라;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

    }

    public static int solution(int[][] routes) {
        int answer = 0;
        List<Integer> spots = new ArrayList<>();
        Map<Integer, List<Integer>> countAndCarIndexMap = new HashMap<>();

        // 구간별 마주치는 차량 정리
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < 2; j++) {
                spots.add(routes[i][j]);
            }
        }
        spots = spots.stream().sorted().collect(Collectors.toList());

        for (Integer spot : spots) {
            countAndCarIndexMap.put();
            spot
        }

        spots


        // 구간별 마주치는 차량 정리
        // 차량수 큰순 정렬
        // 큰수부터...

        while(!isFindAllCar) {

        }

        return answer;
    }
}

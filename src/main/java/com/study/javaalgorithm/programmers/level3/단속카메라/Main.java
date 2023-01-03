package com.study.javaalgorithm.programmers.level3.단속카메라;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("answer : " + solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
        System.out.println("answer : " + solution(new int[][] {{0,0}, {0,0}, {2, 2}}));
        System.out.println("answer : " + solution(new int[][] {{0,-300000}, {1,-300000}, {2, -300000}}));
    }


    public static int solution(int[][] routes) {
        // 나간 위치로 오름차순 정렬
        for (int[] route : routes) {
            if (route[0] > route[1]) {
                int temp = route[0];
                route[0] = route[1];
                route[1] = temp;
            }
        }
        Arrays.sort(routes, Comparator.comparingInt(value -> value[1]));
        System.out.println(Arrays.deepToString(routes));

        int count = 0;
        int i = 0;
        while (i < routes.length) {
            int camera = routes[i][1];
            System.out.println("camera = " + camera);
            i++;
            while (i < routes.length &&  routes[i][0] <= camera && camera <= routes[i][1]) {
                i++;
            }
            count++;
        }

        return count;
    }

    /**
     * 리스트를 활용한 해결
     * @param routes
     * @return
     */
    public static int solutionByList(int[][] routes) {
        int answer = 0;
        int len = routes.length;
        List<int[]> list = new ArrayList<>();
        for(int[] route : routes) {
            list.add(route);
        }
        System.out.println("빨리 나가는 순서대로 정렬해준다.");
        Collections.sort(list, Comparator.comparingInt(a -> a[1]));
        while(!list.isEmpty()) {
            System.out.println("첫 번째 차가 빠져나가는 지점을 구한다.");
            int position = list.get(0)[1];

            System.out.println("그 지점에 카메라를 설치함으로써 더이상 고려하지 않아도 되는 차들에 대한 정보를 빼준다.");
            for(int i = 0; i<list.size(); i++ ) {
                if(list.get(i)[0]<=position){
                    list.remove(i);
                    i--;
                }
            }

            System.out.println("카메라가 한대 설치 되었으므로 answer를 1 키워준다.");
            answer++;
        }
        return answer;
    }
}

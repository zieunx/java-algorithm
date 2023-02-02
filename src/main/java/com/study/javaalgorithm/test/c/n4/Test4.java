package com.study.javaalgorithm.test.c.n4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Test4 {
    public int[] solution(int[][] blocks) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(blocks[0][1]);
        int[] prevArr = { blocks[0][1] };

        for (int i = 1; i < blocks.length; i++) {
            System.out.println("prevArr: " + Arrays.toString(prevArr));
            int[] currentArr = new int[i + 1];
            int startIndex = blocks[i][0];
            currentArr[startIndex] = blocks[i][1];

            // fill left
            int leftIndex = startIndex - 1;
            while (leftIndex >= 0) {
                currentArr[leftIndex] = prevArr[leftIndex] - currentArr[leftIndex + 1];
                leftIndex--;
            }

            // fill right
            int rightIndex = startIndex + 1;
            while (rightIndex < currentArr.length) {
                currentArr[rightIndex] = prevArr[rightIndex - 1] - currentArr[rightIndex - 1];
                rightIndex++;
            }

            System.out.println("currentArr: " + Arrays.toString(currentArr));

            list.addAll(Arrays.stream(currentArr).boxed().collect(Collectors.toList()));
            prevArr = currentArr;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}

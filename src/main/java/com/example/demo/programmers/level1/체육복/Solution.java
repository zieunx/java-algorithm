package com.example.demo.programmers.level1.체육복;


import java.util.*;

/*
프로그래머스 그리디(탐욕법) - 체육복
https://programmers.co.kr/learn/courses/30/lessons/42862
* */
public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int solution = solution(n, lost, reserve);

        System.out.println(solution);
    }

    /*public static int solution(int n, int[] lost, int[] reserve) {

        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();

        for (int reserveN : reserve) {
            reserveList.add(reserveN);
        }

        for (int lostN : lost) {
            lostList.add(lostN);
        }

        List<Integer> finalLostList = lostList;
        reserveList = reserveList.stream()
                .filter(reserveN -> !finalLostList.contains(reserveN))
                .sorted()
                .collect(Collectors.toList());

        List<Integer> finalReserveList = reserveList;
        lostList = lostList.stream()
                .filter(lostN -> !finalReserveList.contains(lostN))
                .sorted()
                .collect(Collectors.toList());

        int canAttendCount = 0;
        for (Integer lostN : lostList) {
            if (reserveList.contains(lostN - 1)) {
                reserveList.remove(lostN - 1);
                canAttendCount++;
            } else if(reserveList.contains(lostN + 1)) {
                reserveList.remove(reserveList.indexOf(lostN + 1));
                canAttendCount++;
            }
        }

        return n - (lostList.size() - canAttendCount);
    }*/


    public static int solution(int n, int[] lost, int[] reserve) {


        Map<Integer, Integer> lostStudent = new HashMap<>();
        Map<Integer, Integer> attendanceStudent = new HashMap<>();

        for (int reserveItem : reserve) {
            attendanceStudent.put(reserveItem, 2);
        }

        for (int lostItem : lost) {
            if(attendanceStudent.containsKey(lostItem)) {
                attendanceStudent.remove(lostItem);
            } else {
                lostStudent.put(lostItem, 0);
            }
        }

        int lostCount = lostStudent.size();

        for (int lostKey : lostStudent.keySet()) {
            int key;
            if(attendanceStudent.containsKey(lostKey - 1)) {
                key = lostKey - 1;
            } else if (attendanceStudent.containsKey(lostKey + 1)) {
                key = lostKey + 1;
            } else {
                continue;
            }
            attendanceStudent.remove(key);
            lostCount -= 1;
        }

        return n - lostCount;
    }
}

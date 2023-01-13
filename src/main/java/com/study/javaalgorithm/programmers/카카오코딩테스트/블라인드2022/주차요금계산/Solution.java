package com.study.javaalgorithm.programmers.카카오코딩테스트.블라인드2022.주차요금계산;

import java.time.LocalTime;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println("result = " + Arrays.toString(solution(
                new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
        )));
    }

    public static int[] solution(int[] fees, String[] records) {
        // 차량번호로 차 찾기
        // 차량번호로 정렬
        // 애초에 정렬해놓고 차량찾는게 편할듯
        Queue<String> sortedCarNumbers = new PriorityQueue<>(Comparator.comparing(Integer::parseInt));
        Map<String, Car> cars = new HashMap<>();

        for (String record : records) {
            String[] s = record.split(" ");
            String[] time = s[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            String number = s[1];
            String status = s[2];

            if (cars.containsKey(number)) {
                cars.get(number).update(status, LocalTime.of(hour, minute));
            } else {
                cars.put(number, new Car(number, LocalTime.of(hour, minute)));
                sortedCarNumbers.add(number);
            }
        }

        System.out.println(cars);

        int[] answer = new int[sortedCarNumbers.size()];

        for (int i = 0; i < answer.length; i++) {
            String number = sortedCarNumbers.poll();
            answer[i] = cars.get(number).calculateFee(fees);
        }

        return answer;
    }

    static class Car {
        private static LocalTime DEFAULT_OUT_TIME = LocalTime.of(23, 59);
        private String number;
        private LocalTime inTime;
        private LocalTime outTime;
        private int total;

        public Car(String number, LocalTime inTime) {
            this.number = number;
            this.inTime = inTime;
            this.outTime = DEFAULT_OUT_TIME;
        }

        public void update(String status, LocalTime recodeTime) {
            if (status.equals("IN")) {
                total += times();
                inTime = recodeTime;
                outTime = DEFAULT_OUT_TIME;
            } else {
                outTime = recodeTime;
            }
        }

        public int calculateFee(int[] fees) {
            int minute = times() + total;
            System.out.println("누적주차시간 : " + (minute));
            if (minute - fees[0] <= 0) {
                return fees[1];
            }
            System.out.println("추가시간:" + Math.ceil((double) (minute - fees[0]) / fees[2]));
            return fees[1] + ((int) (Math.ceil((double) (minute - fees[0]) / fees[2])) * fees[3]);
        }

        private int times() {
            int outMin = outTime.getHour() * 60 + outTime.getMinute();
            int inMin = inTime.getHour() * 60 + inTime.getMinute();
            return outMin - inMin;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Car car = (Car) o;

            return Objects.equals(number, car.number);
        }

        @Override
        public int hashCode() {
            return number != null ? number.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "{number='" + number +
                    ", " + inTime +
                    ", " + outTime +
                    "}\n";
        }
    }
}
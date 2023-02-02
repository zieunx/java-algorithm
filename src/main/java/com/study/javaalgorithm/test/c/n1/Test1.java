package com.study.javaalgorithm.test.c.n1;

import java.util.Arrays;

public class Test1 {
    public int solution(int[][] atmos) {
        int answer = 0;

        int maskDays = 0;
        for (int[] day : atmos) {
            Status fineDustStatus = Status.findFineDust(day[0]);
            Status ultrafineDustStatus = Status.findUltrafineDustMax(day[1]);

            if (fineDustStatus.ordinal() >= Status.BAD.ordinal() ||
                    ultrafineDustStatus.ordinal() >= Status.BAD.ordinal()) {
                maskDays += 1;

                if (maskDays == 1) {
                    answer += 1;
                }

                if (fineDustStatus == Status.VERY_BAD && ultrafineDustStatus == Status.VERY_BAD) {
                    maskDays = 0;
                }
            } else if (maskDays > 0) {
                maskDays += 1;
            }

            if (maskDays == 3) {
                maskDays = 0;
            }

        }

        return answer;
    }

    enum Status {
        GOOD(30, 15),
        NORMAL(80, 35),
        BAD(150, 75),
        VERY_BAD(Integer.MAX_VALUE, Integer.MAX_VALUE);

        private int fineDustMax;
        private int ultrafineDustMax;

        Status(int fineDustMax, int ultrafineDustMax) {
            this.fineDustMax = fineDustMax;
            this.ultrafineDustMax = ultrafineDustMax;
        }

        public static Status findFineDust(int concentration) {
            return Arrays.stream(Status.values())
                    .filter(status -> concentration <= status.fineDustMax)
                    .findFirst()
                    .orElse(null);
        }

        public static Status findUltrafineDustMax(int concentration) {
            return Arrays.stream(Status.values())
                    .filter(status -> concentration <= status.ultrafineDustMax)
                    .findFirst()
                    .orElse(null);
        }
    }
}

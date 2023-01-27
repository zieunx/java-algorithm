package com.study.javaalgorithm.test.b;

public class Test1 {
    public String solution(String input) {
        String[] split = input.split(" ");
        String[] box = new String[split.length];

        for (String text : split) {
            int index = Integer.parseInt(text.substring(text.length() - 1)) - 1;
            String item = text.substring(0, text.length() - 1);

            box[index] = item;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < box.length; i++) {
            sb.append(box[i]);

            if (i != box.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}

package com.study.javaalgorithm.beakjoon.스택.스택수열;
import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        Queue<Integer> sequence = new LinkedList<>(); // 수열
        Stack<Integer> stack = new Stack<>(); // 오름차순 스택

        for (int i = 0; i < N; i++) {
            sequence.add(Integer.parseInt(reader.readLine()));
        }

        // 스택에 쌓일 값을 기준으로 반복문 실행
        for (int ValueToAdd = 1; ValueToAdd <= N; ValueToAdd++) {
            if(sequence.isEmpty()) {
                break;
            }

            plus(stack, ValueToAdd);

            while (!stack.empty() && !sequence.isEmpty() && stack.peek().equals(sequence.peek())) {
                minus(stack);
                sequence.poll();
            }
        }


        if (stack.isEmpty()) {
            writer.write(answer.toString().trim());
        } else {
            writer.write("NO");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    static void plus(Stack<Integer> stack, Integer n) {
        answer.append("+\n");
        stack.add(n);
    }

    static void minus(Stack<Integer> stack) {
        answer.append("-\n");
        stack.pop();
    }
}

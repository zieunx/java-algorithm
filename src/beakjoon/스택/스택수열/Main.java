package beakjoon.스택.스택수열;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        Queue<Integer> sequence = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            sequence.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 1; i <= N; i++) {
            plus(stack, i);

            while (!stack.empty() && stack.peek() == sequence.peek()) {
                minus(stack);
                sequence.poll();
            }
        }


        if (stack.isEmpty()) {
            writer.write(answer.toString());
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

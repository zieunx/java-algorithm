package com.example.demo.beakjoon;

import java.util.Scanner;
public class n10828 {
    static int[] array;
    static int top;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        array = new int[N]; // 스택 초기화
        top = -1;
        sc.nextLine();

        String line;
        while (N >0) {
            line = sc.nextLine();
            switch (line.substring(0,3)) {
                case "pus":
                    push(Integer.parseInt(line.split(" ")[1]));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "siz":
                    System.out.println(size());
                    break;
                case "emp":
                    System.out.println(empty());
                    break;
                case "top":
                    System.out.println(top());
                    break;
            }
            N--;
        }
        sc.close();
    }

    public static void push(int x) {
        top++;
        array[top] = x;
    }

    public static int pop() {
        if (top < 0) {
            return -1;
        } else {
            top--;
            return array[top + 1];
        }
    }

    public static int size() {
        return top+1;
    }

    public static int empty() {
        if (top < 0) {
            return 1;
        }
        return 0;
    }

    public static int top() {
        if (top < 0) {
            return -1;
        }
        return array[top];
    }
}
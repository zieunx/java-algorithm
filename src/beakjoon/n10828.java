package beakjoon;

import java.util.Scanner;
public class n10828 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack stack = new Stack(N); // 스택 초기화
        sc.nextLine();

        String line;
        while (N >0) {
            line = sc.nextLine();
            switch (line.substring(0,3)) {
                case "pus":
                    stack.push(Integer.parseInt(line.split(" ")[1]));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "siz":
                    System.out.println(stack.size());
                    break;
                case "emp":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }
            N--;
        }
    }
}

class Stack {
    int[] array;
    int top;

    public Stack(int n) {
        this.array = new int[n];
        top = -1;
    }

    void push(int x) {
        top++;
        array[top] = x;
    }

    int pop() {
        if (top < 0) {
            return -1;
        } else {
            top--;
            return array[top + 1];
        }
    }

    int size() {
        return top+1;
    }

    int empty() {
        if (top < 0) {
            return 1;
        }
        return 0;
    }

    int top() {
        if (top < 0) {
            return -1;
        }
        return this.array[top];
    }
}

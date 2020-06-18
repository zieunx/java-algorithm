package beakjoon;

import java.util.Scanner;

public class n4949 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CharStack stack = new CharStack(100);
        while(true) {
            stack.reset();
            String sentence = sc.nextLine();
            // boolean haveBracket = false;
            if (sentence.equals(".")) {
                break;
            }
            for (int i = 0; i < sentence.length(); i++) {
                char current = sentence.charAt(i);
                // 괄호 아닌 경우 coutinue
                if (!isStartBracket(current) && !isEndBracket(current)) {
                    continue;
                }
                // haveBracket = true;
                // 시작 괄호일 때 push 후 coutinue
                if (isStartBracket(current)) {
                    stack.push(current);
                    continue;
                }
                // 닫힘 괄호의 경우
                // 짝이 안맞으면  반복문 종료.
                if (!isCouple(stack.top(), current)) {
                    stack.push('('); // * 방어코드 *
                    break;
                }
                // 짝이 맞으면 스택에서 열림괄호 pop.
                stack.pop();
            }
            // 스택이 비었거나 괄호가 없으면, 균형잡힌 문장 
            if (stack.empty()) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }

        sc.close();
    }
    
    static boolean isStartBracket(char c) {
        return c == '(' || c == '[';
    }

    static boolean isEndBracket(char c) {
        return c == ')' || c == ']';
    }

    static boolean isCouple(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']');
    }
}


class CharStack {
    char[] arr;
    int size=0;

    public CharStack (int length) {
        this.arr = new char[length];
        this.size = 0;
    }

    void push(char bracket) {
        arr[size] = bracket;
        size++;
    }

    char pop() {
        if (size == 0) {
            return 'n';
        }
        size--;
        return arr[size];
    }

    int size() {
        return size;
    }

    boolean empty() {
        return size == 0;
    }

    char top() {
        if (size == 0) {
            return 'n';
        }
        return arr[size-1];
    }

    void reset() {
        this.arr = new char[this.arr.length];
        this.size = 0;
    }
}
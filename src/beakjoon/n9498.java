package beakjoon;

import java.util.Scanner;


// success
public class n9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        char grade;
        if (100 >= score && score >= 90) {
            grade = 'A';
        } else if (89 >= score && score >= 80) {
            grade = 'B';
        } else if (79 >= score && score >= 70) {
            grade = 'C';
        } else if (69 >= score && score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.print(grade);

    }
}

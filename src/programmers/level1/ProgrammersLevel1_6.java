package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String answer = solution(num);
        System.out.println(answer);
    }

    public static String solution(int num) {
        String answer = "";

        // 짝수
        if (num % 2 == 0) {
            answer = "Even";
        }

        // 홀수
        else {
            answer = "Odd";
        }

        return answer;
    }
}

// 0은 짝수로 친다.

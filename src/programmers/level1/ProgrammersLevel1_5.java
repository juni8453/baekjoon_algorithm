package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int answer = solution(num);
        System.out.println(answer);
    }

    public static int solution(long num) {
        int answer = 0;

        while(num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                answer += 1;
            }

            else if (num % 2 != 0) {
                num = num * 3 +1;
                answer += 1;
            }
        }

        if (answer > 500) {
            answer = -1;
        }
        return answer;
    }
}

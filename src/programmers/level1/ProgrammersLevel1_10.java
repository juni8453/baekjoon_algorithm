package level1;

import java.util.Scanner;

public class ProgrammersLevel1_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String answer = solution (n);
        System.out.println(answer);

    }

    private static String solution(int n) {
        String answer = " ";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer += "수";
            }

            if (i % 2 != 0) {
                answer += "박";
            }
        }

        return answer;
    }
}

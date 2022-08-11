package programmers.level1;

import java.util.Arrays;
import java.util.Scanner;

public class ProgrammersLevel1_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        int[] answer = solution(n);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long n) {
        String str = String.valueOf(n);
        int length = str.length();
        int[] answer = new int[length];
        int[] reverseAnswer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < length; i++) {
            reverseAnswer[i] = answer[length - i - 1];
        }

        return reverseAnswer;
    }
}

package study.section1;

import java.util.Scanner;

public class Section0103Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = solution(input);
        System.out.println(answer);
    }

    private static String solution(String input) {
        String answer = "";
        int maxValue = Integer.MIN_VALUE; // 최대값 갱신을 위해 가장 작은 값 셋팅
        String[] split = input.split(" ");

        for (String str : split) {
            int length = str.length();

            if (length > maxValue) {
                maxValue = length;
                answer = str;
            }
        }

        return answer;
    }
}

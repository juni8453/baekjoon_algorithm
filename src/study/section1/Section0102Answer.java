package study.section1;

import java.util.Scanner;

public class Section0102Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = solution(input);
        System.out.println(answer);
    }

    private static String solution(String input) {
        StringBuffer answer = new StringBuffer();

        for (char x : input.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer.append(Character.toUpperCase(x));
            } else {
                answer.append(Character.toLowerCase(x));
            }
        }

        return answer.toString();
    }
}

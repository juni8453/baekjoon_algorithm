package study.section1;

import java.util.Scanner;

public class Section0102 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = solution(input);

        System.out.println(answer);
    }

    private static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        String[] split = input.split("");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(split[i].toUpperCase())) {
                split[i] = split[i].toLowerCase();
            }

            else if (split[i].equals(split[i].toLowerCase())) {
                split[i] = split[i].toUpperCase();
            }

            sb.append(split[i]);
        }

        return sb.toString();
    }
}

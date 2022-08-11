package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = sc.next();

        String answer = solution(phoneNumber);
        System.out.print(answer);
    }

    private static String solution(String phoneNumber) {
        int numberLength = phoneNumber.length() - 4;
        String answer;

        for (int i = 0; i < numberLength; i++) {
            System.out.print("*");
        }

        answer = phoneNumber.substring(phoneNumber.length() - 4, phoneNumber.length());

        return answer;
    }
}

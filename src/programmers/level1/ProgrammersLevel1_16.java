package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] strings = new String[n];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.next();
        }

        String answer = solution(strings);
        System.out.println(answer);
    }

    private static String solution(String[] strings) {
        String answer = "";
        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("Kim")) {
                count = i;
                answer = "김서방은" + " " + count + "에 있다";
            }
        }

        return answer;
    }
}

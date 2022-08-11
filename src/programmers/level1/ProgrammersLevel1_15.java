package level1;

import java.util.Scanner;

public class ProgrammersLevel1_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int answer = solution(input);
        System.out.println(answer);
    }

    public static int solution(String input) {
        int answer;

        answer = Integer.parseInt(input);

        return answer;
    }
}

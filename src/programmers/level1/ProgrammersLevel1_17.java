package level1;

import java.util.Scanner;

public class ProgrammersLevel1_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        boolean answer = solution(input);
        System.out.println(answer);
    }

    private static boolean solution(String input) {
        boolean answer = true;

        if(input.length() == 4 || input.length() == 6) {
            for (int i = 0; i < input.length(); i++) {
                char check = input.charAt(i);

                if ('0' < check && check <= '9') {
                    continue;
                }

                if (Character.isLowerCase(check) || Character.isUpperCase(check)) {
                    answer = false;
                }
            }
        } else {
            answer = false;
        }

        return answer;
    }
}

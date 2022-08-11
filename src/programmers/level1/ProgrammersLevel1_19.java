package level1;

import java.util.Scanner;

public class ProgrammersLevel1_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        boolean answer = solution(input);
        System.out.println(answer);
    }

    private static boolean solution(String input) {
        boolean answer = true;
        int countP = 0;
        int countY = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'p' || input.charAt(i) == 'P') {
                countP += 1;
            }

            if (input.charAt(i) == 'y' || input.charAt(i) == 'Y') {
                countY += 1;
            }
        }

        if (countP != countY) {
            answer = false;
        }

        return answer;
    }
}

// input 에 p,y 개수가 같다면 true, 다르면 false 리턴
// p,y 둘다 없는 경우 true 리턴
// 단, 개수를 비교할 때 대소문자는 가리지 않음

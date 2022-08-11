package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProgrammersLevel1_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] inputStr = new String[count];

        for (int i = 0; i < inputStr.length; i++) {
            inputStr[i] = sc.next();
        }

        int n = sc.nextInt();

        String[] answer = solution(inputStr, n);

        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static String[] solution(String[] inputStr, int n) {
        String[] answer = new String[inputStr.length];

        for (int i = 0; i < inputStr.length; i++) {
            char checkSecondChar = inputStr[i].charAt(n);
            answer[i] = checkSecondChar + inputStr[i];
        }

        Arrays.sort(answer, Comparator.naturalOrder());

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i].substring(1);
        }


        return answer;
    }
}

// 인덱스 n의 문자가 같은 문자열이 여럿 일 경우
// 사전순으로 앞선 문자열이 앞쪽에 위치한다.
// [abce, abcd, cdx] -> return [abcd, abce, cdx]

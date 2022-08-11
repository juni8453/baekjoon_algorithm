package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        int length = sc.nextInt();

        String answer = solution(inputStr, length);
        System.out.println(answer);
    }

    public static String solution(String inputStr, int length) {
        String answer = "";

        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);

            // 소문자일 때,
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + length) % 26 + 'a');
            }

            // 대문자일 때,
            else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + length) % 26 + 'A');
            }
            answer += ch;
        }

        return answer;
    }
}
// str      length  return
// "AB"	    1	    "BC"
// "z"	    1	    "a"
// "a B z"	4	    "e F d"

// 공백은 아무리 밀어도 공백이다.
// 입력받는 문자는 소문자, 대문자, 공백으로만 이루어져있다.
// 아스키 코드 활

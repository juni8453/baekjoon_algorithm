package study.section1;

import java.util.Scanner;

public class Section0105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        String answer = solution(input);
        System.out.println(answer);
    }

    private static String solution(String input) {
        String answer = "";
        char[] s = input.toCharArray();
        int lt = 0;  // 인덱스 0부터 위로 ++
        int rt = input.length() - 1;  // 인덱스 9부터 아래로 --

        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(s);
        return answer;
    }
}

// 특정 문자 뒤집기
/*
알파벳 + 특수문자로 구성된 문자열이 주어진다.
만약 특수문자가 있다면 특수문자는 냅두고 알파벳끼리만 뒤집어야 한다.
즉, 좌측도 알파벳, 우측도 알파벳이여야 뒤집는 것
 */

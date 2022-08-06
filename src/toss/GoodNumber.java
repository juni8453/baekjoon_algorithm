package toss;

import java.util.Scanner;

public class GoodNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int answer = solution(str);
        System.out.println(answer);
    }

    private static int solution(String str) {
        int answer = 0;
        String result = "";
        int lt = 0;
        int rt = 1;

        char[] chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(i);
        }

        // 만약 lt 와 rt 를 비교했을 때 다르다면, lt 와 rt 를 각각 1씩 증가한다.
        for (int i=0; i<chars.length; i++) {
            while(rt < chars.length) {
                if (chars[lt] != chars[rt]) {
                    lt += 1;
                    rt += 1;

                // 만약 lt 인덱스 값과 rt 인덱스 값이 같다면, ~ 한 후 rt 만 1씩 증가한다.
                } else {
                    result += chars[lt];
                    rt += 1;
                }
            }
        }

        result += chars[lt];

        answer = Integer.parseInt(result);
        return answer;
    }
}

// 12223 -> 222
// 111999333 -> 999
// 123 -> -1
// 000 -> 0

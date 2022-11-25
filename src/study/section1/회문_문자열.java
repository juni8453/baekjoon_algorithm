package study.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        String answer = "YES";
        int lp = 0;
        int rp = input.length() - 1;

        while (lp != (input.length() / 2)) {
            if (input.charAt(lp) != input.charAt(rp)) { // 회문이 아니므로 종료
                answer = "NO";
                break;
            }

            lp++;
            rp--;

        }

        System.out.println(answer);
    }
}

// 간단하게 StringBuilder 로 풀 수도 있다 !
// StringBuilder sb = new StringBuilder();
//        sb.reverse().toString();
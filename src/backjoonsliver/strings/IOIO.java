package backjoonsliver.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine()); // s 의 길이
        String s = br.readLine(); // 문자열 s

        // 2. 풀이 시작
        // n 의 수에 따라 IOI 를 만들어준다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1 + n ; i++) {
            if (i % 2 == 0) {
                sb.append("I");
            } else {
                sb.append("O");
            }
        }

        // 문자열 s에서 pn 길이만큼의 윈도우를 만들고 한칸씩 전진하며 pn 과 같은지 확인한다.
        String pn = sb.toString();
        int count = 0;

        for (int i = 0; i < s.length() - pn.length(); i++) {
            StringBuilder window = new StringBuilder();

            // pn 갯수에 맞춰서 window 를 생성해야 한다.
            for (int j = 0; j < pn.length(); j++) {
                window.append(s.charAt(i + j));
            }

            if (pn.equals(window.toString())) {
                count++;
            }
        }

        System.out.println(count);
    }
}

// N+1개의 I와 N개의 O로 이뤄져있으면, I와 O가 교대로 나오는 문자열을 PN 이라 한다.
// P1 -> IOI
// P2 -> IOIOI
// P3 -> IOIOIOI
// 무조건 맨 뒤에 I 나옴

// I 와 O 로 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어있는지 구해라.
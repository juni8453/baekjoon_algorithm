package baekjoonbronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 팰린드롬인지_확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Character> a = new ArrayList<>();
        int answer = 1;

        // 단어 길이가 짝수일 때
        if (s.length() % 2 == 0) {
            for (int i = 0; i < s.length(); i++) {
                a.add(s.charAt(i));
            }

            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) == a.get(a.size() - i - 1)) {
                    continue;

                } else {
                    answer = 0;
                }
            }

            // 홀수일 때
        } else {
            int midIndex = s.length() / 2;
            for (int i = 0; i < s.length(); i++) {
                if (i == midIndex) {
                    continue;

                } else {
                    a.add(s.charAt(i));
                }
            }

            // 1,2,3,4 | 4,3,2,1
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) == a.get(a.size() - i - 1)) {
                    continue;

                } else {
                    answer = 0;
                }
            }
        }

        System.out.println(answer);
    }
}

// 단어가 앞으로 읽을 때, 거꾸로 읽을 떄 똑같은 단어인지 확인하고 맞다면 1, 아니라면 0을 출력하시오.
/*

 * 홀수 (1,3,5,7,9) -> 중앙 (1,2,3,4,5)
 * car -> 3글자 중앙은 2 인덱스 1
 * level -> 5글자 중앙은 3 인덱스 2
 * hoooooi -> 7글자 중앙은 4 인덱스 3
 * 123454321 -> 9글자 중앙은 5 인덱스 4
 * */

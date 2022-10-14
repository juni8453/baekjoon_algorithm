package backjoonsliver.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String standard = br.readLine();
        int[] alphabet = new int[26];

        for (int i = 0; i < standard.length(); i++) {
            alphabet[standard.charAt(i) - 'A']++;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            String compare = br.readLine();
            int[] clone = alphabet.clone();
            int same = 0;

            for (int j = 0; j < compare.length(); j++) {
                if (clone[compare.charAt(j) - 'A'] > 0) {
                    same++;
                    clone[compare.charAt(j) - 'A']--;
                }
            }

            // s = ABC, c = ABD 인 경우 same == 2
            // 이 경우에는 문자 하나만 바꾸면 같은 구성이 나오니까 비슷한 단어라고 체크해야한다.
            if (standard.length() == compare.length() && same == standard.length() - 1) {
                count++;

            // s = ABC, c = ABC 인 경우 same = 3
            // 이 경우는 완전 같은 경우이므로 비슷한 단어라고 체크한다.
            } else if (standard.length() == compare.length() && same == standard.length()) {
                count++;

            // s = ABC, c = ABCC 인 경우 same == 3
            // 이 경우는 문자 하나만 뺴면 같은 구성이 나오니까 비슷한 단어라고 체크한다.
            } else if (standard.length() == compare.length() - 1 && same == standard.length()) {
                count++;

            // s = ABC, c = AB 인 경우 same == 2
            // 이 경우는 문자 하나만 더하면 같은 구성이 나오니까 비슷한 단어라고 체크한다.
            } else if (standard.length() == compare.length() + 1 && same == standard.length() - 1) {
                count ++;
            }
        }

        System.out.println(count);
    }
}


// GOD -> [1 ,1 ,1] / GOOD -> [1, 2, 1] 비슷한 단어
// 비교 문자에서 문자를 하나 더하거나 빼거나 바꾸거나 해서 기준 문자와 동일한 단어가 나온다면 비슷한 단어라고 한다.
// GOOD -> [1, 2, 1] 에서 O 를 빼면 (O 인덱스를 뺴면) GOD -> [1, 1, 1] 이 되어 같은 단어가 되니까 이 두 단어는 비슷한 단어이다.
// 비슷한 단어의 갯수를 출력하는 프로그램을 작성해라.
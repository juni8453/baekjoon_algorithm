package baekjoonbronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] apb = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            apb[ch - 'a']++; // 'a' 를 뺸다면 해당 알파벳이 위치한 인덱스가 나옴.
        }

        for (int i : apb) {
            System.out.print(i + " ");
        }
    }
}

// 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하라.
// a -> apb[0] + 1
// b -> apb[1] + 1

// 아스키코드 상 'a' = 97, 'b' = 98 ...
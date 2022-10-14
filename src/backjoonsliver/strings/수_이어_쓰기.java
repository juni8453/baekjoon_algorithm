package backjoonsliver.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수_이어_쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int point = 0; // 인덱스 번호
        int base = 0;

        // 브루트포스 완전탐색으로 풀이
        while (base++ <= 30000) {
            String baseStr = String.valueOf(base);
            for (int i = 0; i < baseStr.length(); i++) {
                if (baseStr.charAt(i) == str.charAt(point)) {
                    point++;
                }

                if (point == str.length()) { // 문자열 길이만큼 다 돌았으니까
                    System.out.println(base);
                    return;
                }
            }
        }

        System.out.println(base);
    }
}

// 234092 -> N = 20
// [1] 234 [567891] 0 [11121314151617181] 92 [0]
// 지운 수 : 1, 567891, 11121314151617181, 0
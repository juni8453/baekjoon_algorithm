package baekjoonbronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ROT13_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            int asciiCode = input.charAt(i);

            // 대문자일 떄,
            if (asciiCode >= 65 && asciiCode <= 90) {
                asciiCode += 13;

                // 대문자 아스키코드 최대 수를 넘어갔을 떄,
                if (asciiCode > 90) {
                    int shift = asciiCode - 91; // 최대범위 + 1만큼 뺴준 뒤,
                    asciiCode = shift + 65; // 다시 'A' 아스키코드를 더해서 문자로 만든다.
                }

            } else if (asciiCode >= 97 && asciiCode <= 122) {
                asciiCode += 13;

                // 소문자 아스키코드 최대 수를 넘어갔을 떄,
                if (asciiCode > 122) {
                    int shift = asciiCode - 123;
                    asciiCode = shift + 97;
                }
            }

            sb.append((char) asciiCode);
        }

        System.out.println(sb);
    }
}

package baekjoonbronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split(" ");
        char[] smallApb =
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] bigApb =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < split.length; i++) {
            if (!checkInteger(split[i])) {
                for (int j = 0; j < split[i].length(); j++) {
                    char ch = split[i].charAt(j);

                    // 대문자라면
                    if ((int) ch <= 90 && (int) ch >= 65) {
                        // 만약 ch = B 였다면 index = 1
                        int index = ch - 'A';
                        if (index > 13) {
                            index -= 13;
                            System.out.print(bigApb[index]);
                        } else {
                            System.out.print(bigApb[index + 13]);
                        }

                    // 소문자라면
                    } else if ((int) ch <= 122 && (int) ch >= 97) {
                        int index = ch - 'a';
                        if (index >= 13) {
                            index -= 13;
                            System.out.print(smallApb[index]);
                        } else {
                            System.out.print(smallApb[index + 13]);
                        }
                    }
                }

                if (i != split.length - 1) {
                    System.out.print(" ");
                }

            // 정수일 때
            } else {
                System.out.println(split[i]);
                continue;
            }
        }
    }

    private static boolean checkInteger(String str) {
        for (int j = 0; j < str.length(); j++) {
            if (Character.isDigit(str.charAt(j))) {
                return true;
            }
        }

        return false;
    }
}

// ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
// 대소문자를 구분한다. b -> o / B -> O
// 'A' ~ 'Z' : 65 ~ 90
// 'a' ~ 'z' : 97 ~ 122

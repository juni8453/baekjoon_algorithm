package baekjoonbronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 농구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] firstName = new String[n];
        String answer = "";
        List<Character> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            firstName[i] = br.readLine();
        }

        int[] apb = new int[26];
        for (int i = 0; i < n; i++) {
            int firstNameIndex = firstName[i].charAt(0) - 'a'; // -97 이므로 0(a)이라면 0번 인덱스에 +1, 1(b)이라면 1번 인덱스에 +1
            apb[firstNameIndex]++;
        }

        // 5명을 선발할 수 있는 상태인지 확인
        for (int i = 0; i < apb.length; i++) {
            if (apb[i] >= 5) {
                int ascii = i + 'a'; // 문자로 바꾸기 위해 'a' 더하기
                char convertedChar = (char)ascii; // 숫자에 해당하는 아스키코드로 변환
                answers.add(convertedChar);
            }
        }

        if (answers.size() != 0) {
            for (char c : answers) {
                System.out.print(c);
            }
        } else {
            answer = "PREDAJA";
            System.out.println(answer);
        }
    }
}

// 성의 첫 글자가 같은 선수 5명은 선발하려고 한다.
// 만약 성의 첫 글자가 같은 선수가 5명보다 적다면, 상근이는 기권하려고 한다.
// 5명보다 적다면 PREDAJA 출력

// index 0 = a
// index 1 = b
// index 2 = c ..
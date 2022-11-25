package study.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복_문자_제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder answer = new StringBuilder();

        // indexOf() 를 통해 최초 발견된 위치와 현재 자신의 위치가 같은 경우가 아니라면 중복된 문자라는 의미이다.
        // 따라서 최초 위치와 현재 위치가 다른 경우는 제외하고 answer 에 붙여준다.
        for (int i = 0; i < input.length(); i++) {
            int a = input.indexOf(input.charAt(i));
            if (i == a) {
                answer.append(input.charAt(i));
            }
        }

        System.out.println(answer);
    }
}


// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
// 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
// 첫 줄에 중복문자가 제거된 문자열을 출력합니다.

// input : ksekkset
// output : kset

// now = k, next = s
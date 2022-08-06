package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section0702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        DFS(number);
    }

    private static void DFS(int number) {
        // 주어진 number 를 2로 나눴을 때 0이 나올 때 까지 재귀하도록 탈출 조건 설정
        if (number == 0) {
            return;

        } else {
            // 2로 나눈 나머지가 출력되도록 재귀 설정
            DFS(number / 2);
            System.out.print(number % 2);
        }
    }
}

// 자연수 n 을 이진수로 바꿔 출력하는 프로그래을 재귀 함수를 사용해 작성해라.
// Input -> 11 / Output -> 1011
// 10진수에서 2진수로 변환하는 방법
/*
* 11 /2 = 5 ...1
* 5 /2 = 2  ...1
* 2 /2 = 1  ...0
* 11(10진수) - 1011(2진수)
* */
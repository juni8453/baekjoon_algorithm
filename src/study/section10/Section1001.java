package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section1001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = solution(N);
        System.out.println(answer);
    }

    private static int solution(int N) {
        int[] arr = new int[N + 1]; // {0, 0, 0, 0, 0}
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[N];
    }
}

/* 계단오르기 (동적 프로그래밍)
* 문제
*   철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
    1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
    그렇다면 총 N 계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
    * 첫 번째 계단까지 오르는 방법 1
    * 두 번째 계단까지 오르는 방법 2
    * 세 번째 계단까지 오르는 방법 3 = 1 + 2 f(n-1) + f(n-2)
    * 네 번째 계단까지 오르는 방법 5 = 2 + 3 f(n-1) + f(n-2)
    * 다섯 째 계단까지 오르는 방법 8 = 3 + 5 f(n-1) + f(n-2)
    * ...
* */
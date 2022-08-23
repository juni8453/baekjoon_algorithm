package mockexam.Day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairDp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1]; // 0은 시작점이라고 두고

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }



        int[] dp = new int[n + 1];
        dp[1] = score[1];

        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= n; i++) {

            // 두 가지 경우의 수를 비교해 더 큰 최대값을 찾고 현재 계단 점수와 더한다.
            // n-3 -> n-1 -> n
            // n-2 -> n

            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}

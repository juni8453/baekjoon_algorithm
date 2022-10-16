package backjoonsliver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100_001];
        Arrays.fill(dp, 987_654_321);
        dp[2] = 1;
        dp[5] = 1;

        int[] coins = {2, 5};

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[n] == 987_654_321) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}

// 2원과 5원으로만 돈을 거슬러준다.
// 손님이 낸 돈 n 이 주어졌을 떄 동전의 최소 갯수를 구하는 프로그램을 작성해라.
// 13 -> (2 + 2 + 2 + 2) + 5 -> 총 5개
// dp[13] = dp[8] + dp[5]
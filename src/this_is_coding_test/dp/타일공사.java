package this_is_coding_test.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일공사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        dp[0] = 1; // 2 * 1 의 덮개를 채우는 하나의 경우 = 1
        dp[1] = 3; // 1 * 2 의 덮개를 채우는 두개의 경우 + 2 * 2 의 덮개를 채우는 하나의 경우 = 3

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 796796;
        }

        System.out.println(dp[n - 1]);
    }
}

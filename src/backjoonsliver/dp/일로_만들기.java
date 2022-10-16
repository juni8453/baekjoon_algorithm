package backjoonsliver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        Arrays.fill(dp, 987_654_321);
        dp[0] = 0;
        dp[1] = 0;

        // 바텀업
        // dp[0], dp[1] 은 어짜피 0 이니까 2부터 끝까지 돌리기
        for (int i = 2; i <= x; i++) {

            // 현재 수에서 -1 연산
            dp[i] = dp[i - 1] + 1;

            // 2로 나눠지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나눠지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[x]);
    }
}

// x 가 3으로 나눠 떨어지면, 3으로 나눈다.
// x 가 2로 나눠 떨어지면, 2로 나눈다.
// x 에서 1을 뺀다.

// 적절하게 위의 연산을 사용해 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값은 ?

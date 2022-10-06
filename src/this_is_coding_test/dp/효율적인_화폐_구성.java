package this_is_coding_test.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인_화폐_구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 1. 문제 유형 파악
        // 해당 문제는 그리디 또는 DP 로 좁혀질 수 있는 문제.
        // -> 그리디 문제가 맞는가 ? -> 무조건 큰 화폐로 나눈다고 해서 최적의 해를 구할 수 없다. -> 그리디 X
        // -> DP 로 풀이.

        // DP 테이블에는 화폐의 갯수를 넣어주자.
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 99999999); // Math.min 사용할 수 있도록 미리 채워두기.
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
                for (int j = coin[i]; j <= m; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        if (dp[m - 1] == 99999999) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m - 1]);
        }

    }
}

// (input)
// 2 15
// 2
// 3

// (output)
// 5 (화폐 3을 5번 내주는 것이 최소한의 화폐 갯수)

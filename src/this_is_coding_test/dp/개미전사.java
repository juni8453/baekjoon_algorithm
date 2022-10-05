package this_is_coding_test.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미전사 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // TODO 창고 0(1), 창고 1(3), 창고 2(1), 창고 3(5)
        // 1. 창고 1 까지만 약탈했다고 했을 때 최대수 = 1
        // 2. 창고 2 까지만 약탈했다고 했을 때 최대수 = 3 (1번 창고를 약탈할 수 없기 때문에)
        // 3. 창고 3 까지만 약탈했다고 했을 떄 최대수 = 3 (1,3 번 창고를 약탈했을 떄 보다 2번 창고를 털었을 때가 최대값이 더 높으니까)
        // 4. 창고 4 까지 약탈했다고 했을 때, 최대수 = 8 (2,4 번 창고를 약탈하는 것이 최대수)
        // DP Table[] = 1 3 3 8 ...
        // i번째 창고를 약탈한다고 가정했을 때, i - 1 번째 창고를 약탈한 합을 더하지 못한다.
        // i번째 창고를 약탈한다고 가정했을 떄, i - 2 번째 창고를 약탈한 합을 더할 수 있다.
        // 그렇다면 i - 1 까지의 최적의 해(여긴 인적이라 i를 더하지 못함)와 i - 2 + i 까지의 최적의 해를 비교해서 더 높은 해를 선택하면 된다.

        int[] dp = new int[n];
        dp[0] = arr[0];

        // 2. 창고 2 까지만 약탈했다고 했을 때 최대수 = 3 (1번 창고를 약탈할 수 없기 때문에)
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        System.out.println(dp[n - 1]);
    }
}

// n = 식량창고의 갯수, k = 각 식량창고에 저장된 식량의 개수
// 3 <= n <= 100, 0 <= k <= 1000

// 4
// 1 3 1 5
// 인접한 식량창고는 약탈 X, 최소 하나 이상 떨어진 식량창고 약탈 O
// 3,5 를 약탈해야만 최대치인 8을 약탈할 수 있음.

// 인접해있다 ?
// [0], [1] / [1], [2] ..
// 즉, 이전에 탐색했던 노드 바로 아래에 있는 노드는 탐색할 수 없다.
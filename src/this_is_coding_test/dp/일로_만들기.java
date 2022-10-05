package this_is_coding_test.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로_만들기 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 문제 유형 파악
        // 당장 생각나는 유형 -> 완전탐색, 그리디 정도 ? 최대한 높은 수로 나눌 수 있도록 -1 연산을 적절히 섞어주는 방법
        // 그리디로 풀이한 해가 최적의 해가 맞는가 ?
        // 5로 나누는 연산을 많이 사용한다고 해서 무조건 최저의 연산횟수가 나오지는 않는다. (7은 3으로도 3번, 5로도 3번 연산해줘야 함 -1 포함해서)
        // n 이 최대 30,000 이기 때문에 완전탐색 시 시간 초과 예상
        // 따라서 DP 로 풀이

        dp(n, 0);
        System.out.println(answer);

    }

    private static void dp(int num, int count) {
        if (num == 1) {
            answer = Math.min(answer, count);
            return;
        }

        // 메모이제이션 활용
        // 현재 구한 최솟값인 answer 보다 많은 연산을 했다고 나온다면 해당 연산 중지 (시간초과 예방)
        if (count >= answer) {
            return;
        }

        if (num % 5 == 0) {
            dp(num / 5, count + 1);
        }

        if (num % 3 == 0) {
            dp(num / 3, count + 1);
        }

        if (num % 2 == 0) {
            dp(num / 2, count + 1);
        }

        dp(num - 1, count + 1);
    }
}

// 정수 n 에 사용할 수 있는 연산은 4가지
// 1. n / 5 == 0 라면 5로 나눈다.
// 2. n / 3 == 0 라면 3으로 나눈다.
// 3. n / 2 == 0 라면 2로 나눈다.
// 4. n 에서 1을 뺀다.

// 적절하게 연산을 사용해 1을 만드는데 연산을 사용하는 횟수의 최솟값을 구하시오.
// 1 <= n <= 30_000

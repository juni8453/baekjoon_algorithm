package programmers.skill_check.level2;

public class 멀리뛰기 {
    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 3;

        System.out.println(new Solution2().solution(n1));
        System.out.println(new Solution2().solution(n2));
    }
}

class Solution2 {
    public long solution(int n) {
        long[] dp = new long[2001]; // dp[] = 각 칸에 도달하기 위한 경우의 수 배열
        dp[0] = 0;
        dp[1] = 1; // 1번째 칸은 한 가지의 경우의 수로 도달
        dp[2] = 2; // 2번째 칸은 두 가지의 경우의 수로 도달

        // Bottom - Up 으로 풀이
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}

// 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
//(1칸, 1칸, 1칸, 1칸)
//(1칸, 2칸, 1칸)
//(1칸, 1칸, 2칸)
//(2칸, 1칸, 1칸)
//(2칸, 2칸)
// 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때,
// 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수를 완성해라
// 예를 들어 4가 입력된다면, 5를 return 한다.
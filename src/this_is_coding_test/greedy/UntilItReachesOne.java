package this_is_coding_test.greedy;

public class UntilItReachesOne {
    public static void main(String[] args) {
        int n = 17;
        int k = 4;
        System.out.println(new Solution().solution(n, k));
    }

    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            int result = n;

            while(result != 1) {
                if (result % k == 0) {
                    result /= k;
                    answer ++;
                } else {
                    result -= 1;
                    answer ++;
                }
            }

            return answer;
        }
    }
}

// 1이 될 떄까지
/*
* n 에서 1을 뺀다.
* 만약 n 이 k 로 나눠 떨어진다면 나눈다.
*
* */

// 25 / 5
// 25 는 5로 나눠 떨어진다. -> 5
// 5는 5로 나눠 떨어진다. -> 1
// answer = 2
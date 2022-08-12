package this_is_coding_test.implement;

public class Time {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int count = 0;

            for (int i = 0; i <= n; i++) { // 0시부터 n시 까지
                for (int j = 0; j < 60; j++) { // 0분 부터 59분 까지
                    for (int k = 0; k < 60; k++) { // 0초 부터 59초 까지
                        if (check(i, j, k)) {
                            count ++;
                        }
                    }
                }
            }

            return count;
        }

        public boolean check(int h, int m, int s) {
            if (h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s % 10 == 3 || s / 10 == 3) {
                return true;
            }
            return false;
        }
    }
}

// 시각
/*
* 0시 0분 0초 ~ N시 59분 59초 까지의 시각 중 3이 하나라도 포함되는 모든 시각을 구해라.
* n = 5 / 5시 59분 59초 까지의 수
*  Output = 11475
* */

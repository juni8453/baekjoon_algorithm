package book.greedy;

public class RuleOfBigNumber {
    public static void main(String[] args) {
        int m = 8;
        int k = 3;
        int[] numbers = {2,4,5,4,6};

        System.out.println(new Solution().solution(m, k, numbers));
    }

    public static class Solution {

        public int solution(int m, int k, int[] numbers) {
            int answer = 0;

            // 가장 큰 수와 두 번쨰로 큰 수를 제외하면 나머지 수는 사용하지 않는다.
            int firstBigNumber = 0;
            int secondMaxNumber = 0;

            // numbers 배열에서 최대값과 두번째로 큰 값 찾기
            for (int num : numbers) {
                if (firstBigNumber < num) {
                    secondMaxNumber = firstBigNumber;
                    firstBigNumber = num;
                }
            }

            while(m != 0) {
                for (int i = 0; i < k; i++) {
                    answer += firstBigNumber;
                    m --;
                }
                answer += secondMaxNumber;
                m --;
            }

            return answer;
        }
    }
}

// 큰 수의 법칙 문제
/*
    k 는 항상 m 보다 작거나 같다.
    숫자가 더해지는 횟수 m(8) / 연속 증감 횟수 제한 k (3)
    numbers = {2,4,5,4,6} 이라면, 법칙에 따라
    6 + 6 + 6 + 5 + 6 + 6 + 6 + 5 = 36 + 10 = 46
*/
package programmers.stack_queue;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] prices2 = {1, 3, 4, 5};
        int[] prices3 = {5, 4, 3, 2, 5};

        System.out.println(Arrays.toString(new Solution3().solution(prices)));
        System.out.println(Arrays.toString(new Solution3().solution(prices2)));
        System.out.println(Arrays.toString(new Solution3().solution(prices3)));
    }
}

class Solution3 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int lt = 0;
        int rt = 1;

        for (int i = 0; i < prices.length; i++) {
            while (rt != prices.length) {
                int stand = prices[lt];
                int compare = prices[rt];

                // 가격 방어 성공
                if (stand <= compare) {
                    answer[lt]++;
                    rt++;

                // 가격 방어 실패
                } else {
                    answer[lt]++;
                    break;
                }
            }

            lt++;
            rt = lt + 1;
        }

        return answer;
    }
}

package book.greedy;

import java.util.ArrayList;
import java.util.List;

public class NumberCardGame {
    public static void main(String[] args) {
        int n = 2;
        int m = 4;
        int[][] cards = {{7, 3, 1, 8}, {3, 3, 3, 4}};

        System.out.println(new Solution().solution(cards));
    }

    static class Solution {
        int solution(int[][] cards) { // n(행), m(열), cards(카드판)
            int minNumberOfNs = Integer.MAX_VALUE;
            int maxNumberOfAnswerArr = Integer.MIN_VALUE;
            List<Integer> answerArr = new ArrayList<>();

            for (int[] ns : cards) {
                // 각 행에서 최소값을 찾는다.
                for (int i = 0; i < ns.length; i++) {
                    if (minNumberOfNs > ns[i]) {
                        minNumberOfNs = ns[i];
                    }
                }
                answerArr.add(minNumberOfNs);
                minNumberOfNs = Integer.MAX_VALUE;
            }

            for (int i : answerArr) {
                if (maxNumberOfAnswerArr < i) {
                    maxNumberOfAnswerArr = i;
                }
            }

            return maxNumberOfAnswerArr;
        }
    }
}

/*
* 3 1 2 -> 1
* 4 1 4 -> 1
* 2 2 2 -> 2
* 각 행에서 가장 낮은 숫자를 뽑고 그 중에서 가장 큰 수를 출력해라.
* */
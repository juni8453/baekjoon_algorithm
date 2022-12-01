package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 명예의_전당 {
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        int k2 = 4;
        int[] score2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        int k3 = 3;
        int[] score3 = {0, 0, 0, 0, 0, 0, 0};

        int k4 = 5;
        int[] score4 = {2, 3, 1};

        System.out.println(Arrays.toString(new Solution().solution(k, score)));
        System.out.println(Arrays.toString(new Solution().solution(k2, score2)));
        System.out.println(Arrays.toString(new Solution().solution(k3, score3)));
        System.out.println(Arrays.toString(new Solution().solution(k4, score4)));
    }
}

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        int[] answer = new int[score.length];
        int minScore = Integer.MAX_VALUE;

        if (k > score.length) {
            for (int i = 0; i < score.length; i++) {
                if (minScore > score[i]) {
                    minScore = score[i];
                }

                answer[i] = minScore;
            }

            return answer;
        }

        // 먼저 초기 k일 까지 출연 가수는 모두 명예의 전당에 오르기 때문에 List 에 삽입
        // k 일 까지의 최하위 점수를 구해 tmpList 에 차례대로 넣어준다.
         for (int i = 0; i < k; i++) {
            if (minScore > score[i]) {
                minScore = score[i];
            }

            mins.add(minScore);
            list.add(score[i]);
        }

        list.sort(Comparator.naturalOrder());

        for (int i = k; i < score.length; i++) {
            if (minScore < score[i]) {
                list.remove(0);
                list.add(score[i]);
                list.sort(Comparator.naturalOrder());
            }

            mins.add(list.get(0));
            minScore = list.get(0);
        }

        for (int i = 0; i < mins.size(); i++) {
            answer[i] = mins.get(i);
        }

        return answer;
    }
}

// 매일 출연한 가수의 점수가 지금까지의 출연 가수들의 점수 중 상위 k 번째 이내라면 해당 가수의 점수를 명예의 전당 목록에 올려 기념
// 즉, 프로그램 시작 이후 초기 k 일까지 출연 가수의 점수는 명예의 전당에 오름.
// k 일 다음부터는 출연 가수의 점수가 기존 명예의 전당 목록의 k 번째 순위의 가수 점수보다 높다면, 출연 가수 점수가 오르고
// 기존 k번째 순위 점수는 명전에서 내려온다.
// 매일 최하위 점수를 발표한다.

// 명전 목록의 점수의 개수 k 와 1일부터 마지막 날까지 출연 가수들의 점수인 score 가 주어졌을 때
// 매일 발표된 명전 최하위 점수를 반환해라.
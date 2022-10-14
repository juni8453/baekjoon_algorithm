package programmers.greedy;

import java.util.Arrays;
import java.util.Collections;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100; // return 3

        int[] people2 = {70, 80, 50};
        int limit2 = 100;

        System.out.println(new Solution().solution(people, limit));
        System.out.println(new Solution().solution(people2, limit2));
    }
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 내림차순으로 정렬
//        Integer[] peoples = IntStream.of(people).boxed().toArray(Integer[]::new);
        Integer[] peoples = new Integer[people.length];
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = people[i];
        }

        Arrays.sort(peoples, Collections.reverseOrder());

        // 80 70 50 50 > limit

        // 투포인터
        int maxIndex = 0; // lt
        int minIndex = peoples.length - 1; // rt

        while (maxIndex < minIndex) {
            int sum = peoples[maxIndex] + peoples[minIndex];
            if (sum > limit) {
                maxIndex++;
                answer++;

            } else {
                maxIndex++;
                minIndex--;
                answer++;

            }
        }

        // 비교하지 못한 사람 한명 남음 (사람 수가 홀수일 때)
        if (maxIndex == minIndex) {
            answer++;
        }

        return answer;
    }
}

// 한 번에 2명 탑승 가능, 무게 제한이 있음 (limit 변수)
// 구명보트를 최대한 적게 사용해 모든 사람을 구출하려고 한다.
// 각 변수가 주어졌을 때 모든 사람을 구출하기 위한 최소한의 보트 갯수는 몇 개인가 ?

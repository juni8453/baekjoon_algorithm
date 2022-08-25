package programmers.sort;

import java.util.Arrays;

public class HIndex_Review {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int[] test = {2, 3, 4, 5, 5, 6, 6};

        System.out.println(new Solution4_1().solution(citations));
        System.out.println(new Solution4_1().solution(test));
    }
}

class Solution4_1 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations); // {2, 3, 4, 5, 5, 6, 6} | {0, 1, 3, 5, 6};

        for (int i = 0; i < citations.length; i++) {
            // citations[i] -> 각 논문이 몇 번 인용되었는지 횟수를 나타내는 배열
            // h -> 기준(citations[i]) 이상 인용된 논문갯수

            int h = citations.length - i;

            if (citations[i] >= h) { // 2 >= 7 | 3 >= 6 | 4 >= 5 | 5 >= 4
                answer = h;
                break;
            }
        }

        return answer;
    }
}

// {2, 3, 4, 5, 5, 6, 6}
// ex) 4번 이상 인용된 논문이 4편 이상이기 때문에 answer = 4;

// {0, 1, 3, 5, 6}
// ex) 3번 이상 인용된 논문이 3편 이상이기 때문에 answer = 3;
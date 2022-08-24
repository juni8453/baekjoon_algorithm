package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {
            {2, 5, 3}, // 2번째부터 5번째까지 잘랐을 때 3번째 수는? -> {5, 2, 6, 3}
            {4, 4, 1}, // 4번째부터 4번째까지 잘랐을 떄 1번째 수는? -> {6}
            {1, 7, 3}  // 1번째부터 7번째까지 잘랐을 때 3번째 수는? -> {1, 5, 2, 6, 3, 7, 4}
        };

        System.out.println(Arrays.toString(new Solution1().solution(array, command)));
    }
}

// i번째 부터 j번째 까지 자른 후, 정렬한 뒤에 k 번째 숫자를 추출하면 된다.
class Solution1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer;
        List<Integer> answerList = new ArrayList<>();

        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2];

            List<Integer> list = new ArrayList<>();

            // i ~ j 까지 list 에 담는다.
            for (; i < j; i++) {
                list.add(array[i]);
            }

            // 정렬 후 k 번째 수를 answerList 에 담는다.
            Collections.sort(list);
            answerList.add(list.get(k - 1));
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

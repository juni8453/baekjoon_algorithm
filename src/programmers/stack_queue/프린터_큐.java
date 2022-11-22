package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class 프린터_큐 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        int[] priorities3 = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int location3 = 1;

        System.out.println(new Solution2_1().solution(priorities, location));
        System.out.println(new Solution2_1().solution(priorities2, location2));
        System.out.println(new Solution2_1().solution(priorities3, location3));
    }
}

class Solution2_1 {
    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        int answer = 0;

        // Queue 셋팅
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Pair(i, priorities[i]));
        }

        // Queue 에서 가장 앞에 위치한 Pair 를 뽑아낸 뒤, Queue 에 남아있는 Pair 를 확인해 방금 뽑은 Pair 보다
        // 더 높은 우선순위를 가진 작업이 존재하는지 확인한다.
        int nowIndex = 0;
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            boolean flag = false;

            for (Pair pair : queue) {
                if (pair.value > currentPair.value) {
                    flag = true; // 현재 뽑아낸 Pair 보다 더 큰 우선순위를 가진 Pair 가 있는 경우
                }
            }

            // 현재 뽑아낸 Pair 보다 더 큰 우선순위를 가진 Pair 가 있다면 현재 Pair 를 Queue 뒤로 보내야 한다.
            if (flag) {
                queue.offer(currentPair);

            // 더 큰 우선순위를 가진 Pair 가 없다면
            } else {
                nowIndex++;

                if (currentPair.index == location) { // 현재 Pair 의 인덱스와 찾으려는 location 이 같다면
                    answer = nowIndex;
                    break;
                }
            }
        }


        return answer;
    }
}

package programmers.stack_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 프린터 {
    public static void main(String[] args) {
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(new Solution2().solution(priorities2, location2));
    }
}

class Solution2 {
    // priorities[] = 중요도 순서 배열 변수
    // location = 내가 인쇄를 요청한 문서가 어떤 위치에 있는지 알려주는 변수
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 우선순위 큐 정수 내림차순 정렬

        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.offer(priorities[i]);
        }

        // 모든 인쇄 대기 목록이 빌 때 까지 반복
        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) { // 큐 값과 매칭되는 경우를 탐색
               if (priorities[i] == priorityQueue.peek()) { // 값만 일치하는 경우 인쇄
                   priorityQueue.poll();
                   answer++;

                   if (i == location) { // 값과 위치가 모두 일치하면 answer 반
                       return answer;
                   }
                }
            }
        }

        return answer;
    }
}

/**
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 */

// 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하는 프로그램을 작성해라.
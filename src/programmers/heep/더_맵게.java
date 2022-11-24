package programmers.heep;

import java.util.PriorityQueue;

public class 더_맵게 {
    public static void main(String[] args) {
        int k = 7;
        int[] scoville = {1, 2, 3, 9, 10, 12};

        System.out.println(new Solution1().solution(k, scoville));
    }
}

class Solution1 {
    public int solution(int k, int[] scoville) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 우선순위 큐에 스코빌 배열 삽입 (스코빌 지수가 낮은 것 부터 큐에 적용)
        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while(queue.peek() < k) {
            if (queue.size() > 1) { // 큐 사이즈가 1보다 작다면 NPE 발생 우려 예외처리
                int firstMin = queue.poll();
                int secondMin = queue.poll();

                // 섞은 음식의 스코빌 지수 = firstMin + (secondMin * 2)
                int mixValue = firstMin + (secondMin * 2);

                queue.offer(mixValue);
                answer++;

            } else {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
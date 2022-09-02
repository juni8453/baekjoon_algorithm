package mockexam.Day0901;

import java.util.*;

public class FunctionDevelopment_Review {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(new Solution2().solution(progresses, speeds)));
    }
}

class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 기능개발에 소요되는 날을 구해주자.
            // (100 - 현재 진행진도) / 개발 속도 -> 소수가 나오는 경우 올림한다. (2.1 -> 3이 될 수 있도록)
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(day);
        }

        List<Integer> list = new ArrayList<>();
        // 큐가 빌 때 까지 탐색
        while (!queue.isEmpty()) {
            int standardDay = queue.poll();
            int count = 1; // 일단 무조건 기능개발 하나는 하는거니까

            while (!queue.isEmpty() && standardDay >= queue.peek()) {
                count++;
                queue.poll();
            }
            list.add(count);
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

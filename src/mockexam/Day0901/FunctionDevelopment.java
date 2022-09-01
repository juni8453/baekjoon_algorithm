package mockexam.Day0901;

import java.util.*;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55}; // 먼저 배포되어야하는 순서대로 작업의 진도가 적힌 배열
        int[] speeds = {1, 30, 5}; // 각 작업의 개발 속도가 적힌 배열
        int[] solution = new Solution().solution(progresses, speeds);
        System.out.println(Arrays.toString(solution));
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] releases = {};

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil(100.0 - progresses[i]) / speeds[i];
            queue.offer(day);
        }

        while (!queue.isEmpty()) {
            int count = 1; // 최소 기능 한 개는 무조건 배포되기 때문에 1로 지정
            int day = queue.poll();

            // 7,3,9 라면 기준을 7로 잡고 3, 9를 확인한다.
            // 7 >= 3 (참) 이라면 7일 걸리는 기능개발이 완료될 때 까지 3일 걸리는 기능은 배포가 안되므로 count++;
            // 7 >= 9 (거짓) 이라면 7일 걸리는 기능개발이 먼저 배포되고 뒤에 9일 걸리는 기능 개발은 함께 배포되는 일이 없으니까 넘어가기
            // day == queue.peek() 일 때도 함꼐 배포되므로 >= 연산자를 사용한 것.
            while (!queue.isEmpty() && day >= queue.peek()) {
                count++;
                queue.poll();
            }

            list.add(count);
        }

        releases = new int[list.size()];

        for (int i = 0; i < releases.length; i++) {
            releases[i] = list.get(i);
        }

        return releases;
    }
}

// 기능개발 문제
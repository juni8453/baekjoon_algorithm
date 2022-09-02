package backjoonsliver.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                queue.offer(x);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.poll());
            } else {
                System.out.println(0 + " ");
            }
        }
    }
}

/* 최소 힙
* x 가 자연수라면 배열에 x 값을 추가
* x 가 0이라면 배열에서 가장 작은 값을 출력, 그 값을 배열에서 제거
* 0이 주어진 횟수만큼 답을 출력해라.
* */

package backjoonsliver.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                queue.offer(x);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.poll() + " ");
            } else {
                System.out.println(0 + " ");
            }
        }

    }
}

// 우선순위 큐 문제
/* 로그램은 맨 처음에는 비어있는 배열에서 시작한다.
* 1. 배열에 자연수 x 를 넣는다.
* 2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
*
* x 가 자연수라면 배열에 해당 x 값을 추가한다.
* x 가 0이라면 배열에서 가장 큰 값을 출력하고 해당 값을 제거한다.
* 0이 주어진 만큼 화면에 출력하고 배열이 빈 경우일 떄 가장 큰 값을 출력하라고 하는 경우에는 0을 출력하라.
* */


// 0 1 2 0 0 3 2 1 0 0 0 0 0
// 0 2 1 3 2 1 0 0
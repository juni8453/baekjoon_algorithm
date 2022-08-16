package backjoonsliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;

public class Boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 절대값을 정렬하기 위한 재정렬 부분
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // 두 수의 절대값이 다른 경우 오름차순
            if (abs1 > abs2) {
                return 1;
            } else if (abs1 < abs2) {
                return -1;

            // 두 수의 절대값이 같은 경우 해당 두 수끼리 오름차순
            } else {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                queue.offer(x);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            else {
                System.out.println(0 + " ");
            }
        }
    }
}

/* 절댓값 힙 문제
* 1. 배열에 정수 x(x != 0) 을 넣는다.
* 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 해당 값을 배열에서 제거한다.
* 3. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고 그 값을 배열에서 제거한다.
*
* x 가 0이 아니라면 배열에 x 값을 추가
* x 가 0이라면 배열에서 절댓값이 가장 작은 값을 출력, 해당 값을 제가
* */

/* input
* 8
* 1
* -1
* 0
* 0
* 2
* -2
* 0
* 0
* */

/* output
 * -1
 * 1
 * -2
 * 2
 * */
package study.section5;

import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Section0506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = solution(n, k);

        System.out.println(answer);
    }

    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        answer = queue.poll();
        return answer;
    }
}

/* 공주 구하기
* N 명의 왕자들은 나이 순으로 1번 부터 N번 까지 번호가 매겨져있고, 순서대로 동그랗게 앉아있다.
* 시계방향으로 1번부터 번호를 외치고, 한 명이 특정 숫자 K 를 외치면 그 왕자는 제외된다.
* 특정 숫자를 외친 왕자 다음 부터 다시 1부터 번호를 외친다.
* 이렇게 반복하다 마지막 한 명의 왕자만이 공주를 구하러 갈 수 있다.
*
* Input: n = 8, k = 3 / Output: 7
* */

// private static int solution(int n, int k) {
//        int answer = 0;
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            list.add(i + 1);
//        }
//
//        int index = 0;
//
//        while (list.size() != 1) {
//            index ++;
//            if (n <= index) {
//                index -= n;
//            }
//
//            if (index % 3 == 0) {
//                list.remove(list.get(index - 1));
//            }
//        }
//
//        return answer;
//    }

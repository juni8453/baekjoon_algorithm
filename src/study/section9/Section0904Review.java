package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Test implements Comparable<Test> {

    int money;
    int time;

    public Test(int money, int time) {
        this.money = money;
        this.time = time;
    }

    // time 기준 내림차순 정렬
    @Override
    public int compareTo(Test o) {
        return o.time - this.time;
    }
}

public class Section0904Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Test> list = new ArrayList<>();
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.add(new Test(money, time));

            // max 를 가장 큰 time 으로 잡아주기 위한 분기문
            if (list.get(i).time > max) {
                max = list.get(i).time;
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.sort(list);

        int j = 0;
        // 3,2,1 순으로 반복문 순회 (가장 큰 시간 기준으로 해야하기 때문에 거꾸로 반복문 설정)
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).time < i) {
                    break;
                }
                queue.offer(list.get(j).money);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }

        System.out.println(answer);
    }
}



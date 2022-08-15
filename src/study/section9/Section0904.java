package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Schedule2 implements Comparable<Schedule2> {

    public int money;
    public int day;

    public Schedule2(int money, int day) {
        this.money = money;
        this.day = day;
    }

    // d 기준 내림차순 정렬
    @Override
    public int compareTo(Schedule2 o) {
        return o.day - this.day;
    }
}

public class Section0904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Schedule2> list = new ArrayList<>();
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Schedule2(money, day));

            if (day > max) {
                max = day;
            }
        }

        // Collections.reversOrder() 가 없다면 젤 작은 값을 우선순위로 두기 때문에
        // 현재 젤 큰 값을 우선순위로 poll() 하기 위해 reversOrder() 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).day < i) {
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

// 최대 수입 스케쥴
// d 일 안에 와서 강연할 시 m 만큼의 강의료를 받아낸다.
// d 와 m 을 바탕으로 가장 많은 돈을 벌 수 있도록 강연 스케쥴을 짜야한다.
// 최대로 벌 수 있는 수입은 ?
/* 6 (n)
*  50 2 (m / d)
*  20 1
*  40 2
*  60 3
*  30 3
*  30 1
*  output -> 150
* */
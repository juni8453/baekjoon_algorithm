package backjoonsliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
    int startTime;
    int dueTime;

    public Time(int startTime, int dueTime) {
        this.startTime = startTime;
        this.dueTime = dueTime;
    }

    // 종료시간 기준 오름차순 정렬 실시
    // 만약 종료시간이 같다면 시작시간 기준으로 오름차순 정렬 실시
    @Override
    public int compareTo(Time o) {
        if (o.dueTime == this.dueTime) {
            return this.startTime - o.startTime;
        } else {
            return this.dueTime - o.dueTime;
        }
    }
}

public class Boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int dueTime = Integer.parseInt(st.nextToken());
            times.add(new Time(startTime, dueTime));
        }

        // 종료시간 기준으로 오름차순 정렬 실시
        // 만일 종료시간이 같다면 시작시간 기준으로 오름차순 정렬
        Collections.sort(times);

        int count = solution(n, times);
        System.out.println(count);
    }

    private static int solution(int n, List<Time> times) {
        int count = 0;

        // 현재 times 에는 각 스케줄의 시작시간, 종료시간이 담겨져 있다.
        // 그리디 알고리즘의 기준 잡기
        // 1. 현재 나의 종료시간이 가장 빠른 상태
        // 2-1. 다음에 선택할 노드의 시작시간이 내 종료시간보다 앞선 시간인가 ? (탈락)
        // 2-2. 다음에 선택할 노드의 시작시간이 내 종료시간보다 앞서지 않는 시간인가 ?
        // 3. 2번을 무사히 통과했고 후보 노드들 중 종료시간이 더 빠른 노드는 무엇인가 ? (선택)
        // 4. 노드를 선택한 뒤 count ++
        // 5. 노드를 선택한 뒤 해당 노드를 기준으로 잡을 수 있게 dueTime 을 해당 노드의 dueTime 으로 교체
        int prevDueTime = 0;
        for (Time time : times) {
            if (prevDueTime <= time.startTime) { // 만약 이전 회의 종료시간이 현재 시작시간보다 작거나 같다면 ?
                prevDueTime = time.dueTime;
                count ++;
            }
        }

        return count;
    }
}

// 회의실 배정
/* 최대로 사용할 수 있는 회의의 최대 개수를 출력해라.
* N개의 회의, N개의 사용시간과 종료시간이 주어지고 한번 시작하면 중간에 중단될 수 없다.
* 사용시간과 종료시간이 같을 수 있고 이 경우는 시작하자마자 끝난 경우라고 할 수 있다.
* */

/* 아이디어
* 회의를 가장 많이 하기 위헤선 빠르게 끝나는 회의 위주로 스케줄을 구성해야 한다.
* 이전 회의의 종료시간과 이후 회의의 시작시간이 최대한 가까운 것으로 구성해야 한다.
* 종료 시간 기준으로 오름차순 정렬을 실시하고 더 짧은 시간을 기준으로 잡은 뒤 하나 씩 선택한다.
* */

/**/

/* Input Example
* 11
* 1 4
* 3 5
* 0 6
* 5 7
* 3 8
* 5 9
* 6 10
* 8 11
* 8 12
* 2 13
* 12 14
* */

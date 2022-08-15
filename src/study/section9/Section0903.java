package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Schedule implements Comparable<Schedule>{
    int time;
    char status;

    public Schedule(int time, char status) {
        this.time = time;
        this.status = status;
    }

    // 만약 시간이 같다면 문자열 기준으로 오름차순 정렬
    @Override
    public int compareTo(Schedule o) {
        if (this.time == o.time) {
            return this.status - o.status;
        } else {
            return this.time - o.time;
        }
    }
}

public class Section0903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Schedule> schedules = new ArrayList<>();
        int answer = Integer.MIN_VALUE;
        int count = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sT = Integer.parseInt(st.nextToken());
            int eT = Integer.parseInt(st.nextToken());
            schedules.add(new Schedule(sT, 's'));
            schedules.add(new Schedule(eT, 'e'));
        }

        Collections.sort(schedules);

        for (Schedule s : schedules) {
            if (s.status == 's') {
                count ++;
            } else {
                count --;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }
}

// 결혼식 문제
/*
* 3일동안 피로연을 진행하며 0시 0분 ~ 72시 0분 까지를 3일로 본다.
* 피로연 장소에 동시에 존재하는 최대 인원수를 구하는 프로그램을 작성해라.
* 오는 시간 13, 가는 시간 15 라면 15에는 이 사람은 존재하지 않는다고 가정한다.
* */

/* 아이디어
* 현재 노드의 가는 시간이 다음 노드의 오는 시간보다 클 때 인원이 곂치는 것으로 간주한다.
* */

/* input
* 5
* 14 18
* 12 15
* 15 20
* 20 30
* 5 14
* */

/* output
* 2
* */
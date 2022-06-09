package study.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Conference implements Comparable<Conference> {

    int startTime, endTime;

    public Conference(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 자기 - 오는거 는 오름차순
    // 오는거 - 자기 는 내림차순 (걍 외우셈)
    // 정렬 기준은기준은 알아서


    @Override
    public int compareTo(Conference conference) {
        if (this.endTime == conference.endTime) {
            return this.startTime - conference.startTime;
        } else {
            return this.endTime - conference.endTime;
        }
    }
}

public class Section0902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Conference> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            arr.add(new Conference(startTime, endTime));
        }

        Collections.sort(arr);

        int firstEndConferenceTime = 0; // 3, 5, 7
        int count = 0; // 1, 2, 3

        for (Conference conference : arr) {
            if (conference.startTime >= firstEndConferenceTime) {
                firstEndConferenceTime = conference.endTime;
                count ++;
            }
        }

        System.out.println(count);
    }
}

// 9-2 회의실 배정
// 1 개의 회의실을 사용하려는 n 개의 회의들에 대해 사용표를 만들려고 한다.
// 각 회의는 시작과 끝 시간이 주어져있고, 각 회의가 곂치지 않게 하면서 회의실을 할 수 있는 최대수의 회의를 찾아라.

// 끝나는 시간 기준으로 오름차순 하면 ?
// 1. 가장 빨리 끝나는 시간을 기준으로 잡는다. (firstEndConferenceTime = 3시)
// 2. 만약 시작 시간이 firstEndConferenceTime 시간 보다 작다면 노카운트 아니라면 카운트

// 2 ~ 3
// 1 ~ 4
// 3 ~ 5
// 4 ~ 6
// 5 ~ 7


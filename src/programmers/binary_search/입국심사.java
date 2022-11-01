package programmers.binary_search;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6; // 입국심사를 기다리는 인원수
        int[] times = {7, 10}; // 각 심사관이 심사하는데 걸리는 시간

        System.out.println(new Solution().solution(n, times));
    }
}

class Solution {
    public long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;

        // 이분탐색은 항상 정렬된 배열로만 실시할 수 있음.
        Arrays.sort(times);

        // 심사를 받는데 걸리는 최소한의 시간을 찾아야하므로 심사를 받는데 걸리는 시간을 이분탐색한다.
        long start = times[0];
        long end = n * (long)times[times.length - 1]; // n 명이 모두 가장 긴 시간이 걸리는 심사대로 가는 최악의 경우

        while (start <= end) {
            long mid = (start + end) / 2;
            int sum = 0; // 주어진 시간(mid) 동안 심사를 받을 수 있는 총 인원

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            // 대기 인원이 심사를 받은 인원보다 많다면 시간이 부족 -> start 늘리기
            if (n > sum) {
                start = mid + 1;

            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }

        }

        return answer;
    }
}

/**
 * 한 심사대에서 동시에 한 명만 심사할 수 있다.
 * 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있다.
 * 하지만, 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있다.
 */

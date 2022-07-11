package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        List<Integer> answers = solution(arr, n, k);

        answers.forEach(s -> System.out.print(s + " "));

    }

    private static List<Integer> solution(int[] arr, int n, int k) {
        List<Integer> answers = new ArrayList<>();
        Map<Integer, Integer> window = new HashMap<>();

        int lt = 0;
        int rt = k - 1;

        // TODO : 최초 윈도우 설정
        for (int i = 0; i < rt; i++) {
            window.put(arr[i], window.getOrDefault(arr[i], 0) + 1);
        }

        // RT 를 끝 최초 윈도우 맨 끝 부분 부터 하나 씩 증가시키기 위해서 i = rt, i < n 으로 반복문 설정
        for (int i = rt; i < n; i++) {
            window.put(arr[i], window.getOrDefault(arr[i], 0) + 1);
            answers.add(window.size());

            // 윈도우를 한 칸 뒤로 밀어야 하니까 윈도우 맨 앞의 값 Value 삭제
            window.put(arr[lt], window.get(arr[lt]) - 1);

            // Map 내부에 Value 가 0인 키값이 있다면 지워준다.
            if (window.get(arr[lt]) == 0) {
                window.remove(arr[lt]);
            }

            lt ++;
        }

        return answers;
    }
}

// N = 7일, K = 4일 (연속된 일수)
// N = { 20, 12, 20, 10, 23, 17, 10 }
// 첫 번째 구간 {20, 12, 20, 10} - 서로 다른 숫자 3개
// 두 번째 구간 {12, 20, 10 ,23} - 서로 다른 숫자 4개
// 세 번쨰 구간 {20, 10, 23, 17} - 서로 다른 숫자 4개
// 네 번째 구간 {10, 23, 17, 10} - 서로 다른 숫자 3개
// 출력 - 3 4 4 3
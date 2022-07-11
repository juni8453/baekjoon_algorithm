package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(firstLine.nextToken());
        int k = Integer.parseInt(firstLine.nextToken());

        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(secondLine.nextToken());
        }

        int answer = solution(n, k, arr);
        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] arr) {
        Set<Integer> answerSet = new HashSet<>();
        int answer = 0;
        int sum = 0;

        // 크기가 k 인 창문 만들기
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        answerSet.add(sum);

        // 한 칸씩 밀고나가면서 answerList 에 추가해놓기.
        // 나중에 List 는 정렬해야 한다.
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answerSet.add(sum);
        }

        // k 번째 숫자가 없는 경우는 -1 을 리턴하기 위해 분기문 추가
        if (answerSet.size() < k) {
            return -1;
        }

        // K 번째로 큰 수를 출력하기 위해 역 정렬
        List<Integer> list = new ArrayList<>(answerSet);
        list.sort(Collections.reverseOrder());

        list.stream().forEach(s -> System.out.println(s + " "));
        System.out.println();

        answer = list.get(k - 1);

        return answer;
    }
}

// K 번째 수 출력하기
// K 번째 수가 존재하지 않다면 -1 을 리턴하라.
// 슬라이딩 윈도우만으로는 모든 3가지 경우의 수가 나오지 않는 것 같다.
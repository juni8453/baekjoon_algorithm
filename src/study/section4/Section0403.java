package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> answers = solution(n, k);

        answers.forEach(s -> System.out.print(s + " "));

    }

    // n - 7
    // k - 4
    private static List<Integer> solution(int n, int k) {
        List<Integer> answers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];



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
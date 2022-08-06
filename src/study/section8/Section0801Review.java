package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0801Review {
    static int[] staticArr;
    static int total;
    static String answer = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        staticArr = arr;

        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int depth, int sum) {
        // depth 가 끝까지 갔다면 부분 집합이 만들어져있는 상태.
        if (depth == staticArr.length) {
            if (sum == total - sum) {
                answer = "YES";
            }

        // 재귀 호출 부분
        } else {
            DFS(depth + 1, sum + staticArr[depth]);
            DFS(depth + 1, sum);
        }
    }
}

// arr 배열을 두 배열로 나눴을 때, 합이 같은 경우가 존재하면 YES, 아니라면 NO 를 출력하는 프로그램을 작성해라.


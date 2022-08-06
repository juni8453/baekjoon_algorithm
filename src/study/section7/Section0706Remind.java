package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section0706Remind {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        // 1번 깊이부터 탐색 시작
        DFS(1);
    }

    private static void DFS(int depth) {
        // n + 1 깊이까지 탐색하면 탈출하도록 탈출 구문 작성
        if (depth == n + 1) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) {
                    stringBuilder.append(i).append(" ");
                }

                // stringBuilder 의 길이가 0이라면 공집합이므로 0보다 클 때만 출력하도록 설정
                if (stringBuilder.length() > 0) {
                    System.out.println(stringBuilder);
                }
            }
        } else {
            // 왼쪽 노드 탐색
            arr[depth] = 1;
            DFS(depth + 1);

            // 오른쪽 노드 탐색
            arr[depth] = 0;
            DFS(depth + 1);
        }
    }
}

// 자연수 n 이 주어졌을 떄, 1부터 n 까지의 수를 가지는 모든 부분집합을 출력해라.
// Input 3 -> {1,2,3}, {1,2}, {1,3}, {1}, {2,3}, {2}, {3}

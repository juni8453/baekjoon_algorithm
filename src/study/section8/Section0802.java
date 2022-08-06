package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0802 {
    static int answer = 0;
    static int cKg = 0;
    static int n = 0;
    static int[] kgArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cKg = Integer.parseInt(st.nextToken()); // 259Kg
        n = Integer.parseInt(st.nextToken()); // 5마리
        kgArr = new int[n];

        for (int i = 0; i < n; i++) {
            kgArr[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int depth, int sum) {
        // 탈출
        // 이 if 문 없으면 오답임;
        if (sum > cKg) {
            return;
        }
        // 위 if 문으로 인해 트럭 무게보다 바둑이의 무게가 더 나갈 일은 없다.
        // 부분집합이 완료되었으니 이전 최고 값과 현재 최고 값을 비교한다.
        if (depth == n) {
            answer = Math.max(sum, answer);

        // 재귀함수 호출 부분
        } else {
            DFS(depth + 1, sum + kgArr[depth]);
            DFS(depth + 1, sum);
        }
    };
}

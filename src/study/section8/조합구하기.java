package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합구하기 {
    static int n;
    static int m;
    static int[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];

        DFS(0, 1);
    }

    private static void DFS(int depth, int start) {
        if (depth == m) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();

        } else {
            for (int i = start; i <= n; i++) {
                combi[depth] = i;
                DFS(depth + 1, i + 1);
            }
        }
    }
}

// 1부터 n까지 번호가 적힌 구슬이 있고 이 중 m 개를 뽑는 방법의 수를 출력해라.
package groom.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 경로의_갯수 {

    static int n;
    static int sum;
    static int answer = Integer.MIN_VALUE;
    static int[] edge;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edge = new int[n];

        checked = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            edge[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);

        System.out.println(answer);
    }

    private static void DFS(int depth) {
        if (depth == n) {
            sum++;
            answer = Math.max(answer, sum);
            return;

        } else {
                for (int k = 0; k < edge[depth]; k++) {
                    if (!checked[depth]) {
                        checked[depth] = true;
                        DFS(depth + 1);
                        checked[depth] = false;
                    }
                }
        }
    }
}

// 다리를 건너는 모든 경우의 수 구하기 (DFS 활용 완전탐색)



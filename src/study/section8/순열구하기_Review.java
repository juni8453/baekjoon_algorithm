package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기_Review {
    static int n, m;
    static int[] checked;
    static int[] arr;
    static int[] pm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        checked = new int[n];
        pm = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
    }

    private static void DFS(int depth) {
        if (depth == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();

        } else {
            for (int i = 0; i < n; i++) {
                if (checked[i] == 0) {
                    checked[i] = 1; // 체크
                    pm[depth] = arr[i];
                    DFS(depth + 1);
                    checked[i] = 0; // 체크 풀어주기
                }
            }
        }
    }
}

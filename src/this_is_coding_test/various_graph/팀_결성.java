package this_is_coding_test.various_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀_결성 {

    static int[] unf;

    static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fb] = fa;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int[] arr = new int[3];
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            // Union 연산 실시
            if (arr[0] == 0) {
                Union(arr[1], arr[2]);

            // Find 연산 실시
            } else if (arr[0] == 1) {
                Find(arr[1]);
                Find(arr[2]);

                if (Find(arr[1]) == Find(arr[2])) {
                    System.out.println("YES");

                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

// 팀 합치기 연산 0 a b
// 팀 여부 확인 연산 1 a b
// n 과 m 의 최대 범위가 100,000 이기 때문에 경로 압축으로 개선된 Union & Find 알고리즘을 사용해야 한다.

/**
 7 8
 0 1 3
 1 1 7
 0 7 6
 1 7 1
 0 3 7
 0 4 2
 0 1 1
 1 1 1
 */
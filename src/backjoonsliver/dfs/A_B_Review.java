package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_B_Review {
    static long a;
    static int b;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        DFS(a, 1);

        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void DFS(long a, int depth) {
        // if 구문에서 탈출조건 부여
        if (a == b) {
            count = depth;
            return;

        // 2가지의 경우로 depth 를 증가시키면서 완전탐색하도록 로직 작성
        } else {
            if (a > b) {
                return;
            } else {
                DFS(a * 2, depth + 1);
                DFS(Long.parseLong(String.valueOf(a) + 1), depth + 1);
            }
        }
    }
}

// 2를 곱하너가 1을 수의 가장 오른쪽에 추가하는 방법 2가지
// A 를 B 로 바꾸는데 필요한 연산의 최솟값은 ?
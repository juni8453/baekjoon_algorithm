package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16953 {
    static long a;
    static long b;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        DFS(a, 1); // a 부터 연산 시작

        if (count != 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    private static void DFS(long a, int depth) {
        // 완전 탐색이기 때문에 if - else 탈출구문 정의
        if (a == b) {
            count = depth;
            return;

        } else {
            if (a < b) {
                DFS(a * 2, depth + 1);
                DFS(Long.parseLong(a + "1"), depth + 1);
            }
        }
    }
}

// 2 곱하기 또는 1을 수의 가장 오른쪽에 추가
// a 를 b 로 바꾸는데 필요한 연산의 최소값에 1을 더한 값을 출력해라.

/*
* 2
* 4                  21
* 8      41          42 211
* 16 81  82 411      ...
*
* */
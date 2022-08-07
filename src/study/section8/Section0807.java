package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

//        int answer = DFS(n, r);
        System.out.println(DFS(n, r));
    }

    private static int DFS(int n, int r) {
        // 조합 공식에 의해 r이 0 || 1 이라면 무조건 1로 고정
        if (r == 0 || n == r) {
            return 1;
        } else {
            return DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
}

/*
* n 의 범위 (3<=n<=33)
* r 의 범위 (0<=r<=n)
* 예) n = 5
* r 의 범위 (0<=r<=5)
* */

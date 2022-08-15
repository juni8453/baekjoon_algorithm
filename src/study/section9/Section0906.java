package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Section0906 {
    static int[] unf;

    // 배열에서 소속된 집합을 찾아주는 메서드
    static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    // 합치는 메서드
    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            Union(a, b);
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st3.nextToken());
        int b = Integer.parseInt(st3.nextToken());

        int fa = Find(a);
        int fb = Find(b);

        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}

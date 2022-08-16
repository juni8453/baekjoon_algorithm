package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Unf implements Comparable<Unf>{
    int sum;
    int aV;
    int bV;

    public Unf(int sum, int aV, int bV) {
        this.sum = sum;
        this.aV = aV;
        this.bV = bV;
    }

    // a 오름차순 정렬
    @Override
    public int compareTo(Unf o) {
        return this.aV - o.aV;
    }
}

public class Boj1717 {
    static int[] arr;

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) arr[fa] = fb;
    }

    static int Find(int v) {
        if(v == arr[v]) return arr[v];
        else return arr[v] = Find(arr[v]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 갯수
        List<Unf> list = new ArrayList<>();
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st2.nextToken());
            int aV = Integer.parseInt(st2.nextToken());
            int bV = Integer.parseInt(st2.nextToken());
            list.add(new Unf(sum, aV, bV));
        }

        for (Unf unf : list) {
            if (unf.sum == 0) {
                Union(unf.aV, unf.bV);
            }

            else if (Find(unf.aV) != Find(unf.bV)) {
                System.out.println("NO");
            }

            else {
                System.out.println("YES");
            }
        }
    }
}

// 초기에 0, 1, 2 .. n 이 각각 n+1 개의 집합을 이루고 있다.
// 0 a b -> Union(a,b)
// 1 a b -> Find(a), Find(b)
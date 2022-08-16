package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    // cost 기준 오름차순 정렬
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Boj1197 {
    static int[] unf;

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static int Find(int v) {
        if(unf[v] == v) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Edge> list = new ArrayList<>();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        unf = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st2.nextToken());
            int v2 = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            list.add(new Edge(v1, v2, cost));
        }

        Collections.sort(list);

        int answer = 0;
        for (Edge edge : list) {
            if (Find(edge.v1) != Find(edge.v2)) {
                answer += edge.cost;
                Union(edge.v1, edge.v2);
            }
        }

        System.out.println(answer);

    }
}

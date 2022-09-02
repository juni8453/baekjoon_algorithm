package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1260 {

    static int[][] map;
    static boolean[] visitCheck;
    static int line; // 간선 개수
    static int node; // 정점 개수
    static int start; // 시작 정점

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        map = new int[node + 1][node + 1];
        visitCheck = new boolean[node + 1];
        Arrays.fill(visitCheck, false);

        for (int i = 0; i < line; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        DFS(start);
    }

    private static void DFS(int start) {
        visitCheck[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < node + 1; i++) {
            if (map[start][i] == 1 && visitCheck[i] == false) {
                DFS(i);
            }
        }
    }

}

package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0712Review {
    static int node;
    static int edge;
    static int answer;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        map = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            map[a][b] = 1;
        }

        visited[1] = true;
        DFS(1);
        System.out.println(answer);
    }

    private static void DFS(int depth) {
        if (depth == node) {
            answer ++;
        } else {
            for (int i = 1; i<=node; i++) {
                if (!visited[i] && map[depth][i] == 1) {
                    visited[i] = true;
                    DFS(i);
                    visited[i] = false;
                }
            }
        }
    }
}

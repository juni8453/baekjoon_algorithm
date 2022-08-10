package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Section0713 {

    static int node;
    static int edge;
    static int answer;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[node + 1];

        // 노드 갯수만큼 인접 리스트 초기화
        // 0은 안쓰니까 <=
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 간선 갯수만큼 돌면서 인접 리스트 채워주기
        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }

        visited[1] = true;
        DFS(1);
        System.out.println(answer);
    }

    private static void DFS(int depth) {
        if (depth == node) {
            answer ++;
        } else {
            for (int nextDepth : graph.get(depth)) {
                // 방문하지 않았다면 ?
                if (!visited[nextDepth]) {
                    visited[nextDepth] = true;
                    DFS(nextDepth);
                    visited[nextDepth] = false;
                }
            }
        }
    }
}

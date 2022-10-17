package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결_요소의_갯수 {

    static int nodeIdx;
    static int edge;
    static int answer;
    static boolean[] checked;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        checked = new boolean[nodeIdx + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= nodeIdx; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 그래프 셋팅
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= nodeIdx; i++) {
            if (!checked[i]) { // 방문 배열을 1부터 하나씩 확인하면서 (노드 0은 없으니까), 방문하지 않은 노드를 찾아 dfs 탐색
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int v) { // v = 탐색 시작 노드
        checked[v] = true;
        for (int nv : graph.get(v)) {
            if (!checked[nv]) {
                dfs(nv);
            }
        }
    }
}

// 양방향 그래프가 주어졌을 때, 연결요소 개수를 구하는 프로그램을 작성하시오.

package groom.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 구름이의_여행 {

    static int nodeIdx; // 섬 개수 및 도착해야 하는 마지막 섬 번호
    static int edge;
    static int maxEdgeIdx;
    static boolean[] checked;
    static int[] dis;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        maxEdgeIdx = Integer.parseInt(st.nextToken());
        checked = new boolean[nodeIdx + 1];
        dis = new int[nodeIdx + 1];
        Arrays.fill(dis, 0);

        graph = new ArrayList<>();
        for (int i = 0; i < nodeIdx + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 그래프 설정
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs();

        if (dis[nodeIdx] <= maxEdgeIdx && dis[nodeIdx] != 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        checked[1] = true;
        dis[1] = 0; // 1번 섬부터 시작하니 1번 섬은 거리 1로 초기화

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nextNode : graph.get(node)) {
                if (!checked[nextNode]) {
                    dis[nextNode] = dis[node] + 1;
                    q.offer(nextNode);
                    checked[nextNode] = true;
                }
            }
        }
    }
}

// 1번 섬에서 N 번 섬까지 K 개 이하의 다리를 사용해서 갈 수 있다면 YES, 없다면 NO 를 출력해라.

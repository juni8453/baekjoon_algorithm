package this_is_coding_test.prctice.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정_거리의_도시_찾기 {

    static int node;
    static int edge;
    static int k;
    static int startNode;
    static int answer;
    static int[] cost;
    static Queue<Integer> queue = new LinkedList<>();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        cost = new int[node + 1];
        Arrays.fill(cost, -1);

        // 2차원 연결리스트 초기화
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        // edge(간선) 만큼 연결정보가 주어진다.
        // 단방향으로 그래프 셋팅
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int aCity = Integer.parseInt(st.nextToken());
            int bCity = Integer.parseInt(st.nextToken());

            graph.get(aCity).add(bCity);
        }

        queue.offer(startNode);
        cost[startNode] = 0;
        bfs();

        // 최단거리가 k인 노드 찾기
        boolean check=false;
        for (int i = 1; i < cost.length; i++) {
            if (cost[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        // 최단거리가 k인 노드가 없다면 -1 출력
        if(!check)
            System.out.println(-1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int nextNode : graph.get(now)) {
                if (cost[nextNode] == -1) { // 중복해서 값을 갱신할 필요가 없기 때문에 시작노드에서 최초로 접근했을 때만 값을 갱신한다.
                    cost[nextNode] = cost[now] + 1;
                    queue.offer(nextNode);
                }
            }
        }
    }

}

// 특정 도시 x 에서 출발해 도달할 수 있는 모든 도시 중, 최단 거리가 정확히 K 인 모든 도시의 번호를 출력해라.
// n = 4, k = 2, x = 1 일 때 최단 거리가 2인 도시는 4번 도시.
// 모든 도로의 길이는 1로 고정한다.
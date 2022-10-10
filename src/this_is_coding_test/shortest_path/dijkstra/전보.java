package this_is_coding_test.shortest_path.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node2 {
    int nodeIdx;
    int cost;

    public Node2(int nodeIdx, int cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}

public class 전보 {

    static int n; // 총 노드 개수
    static int m; // 총 간선 개수
    static int c; // 시작 노드 번호
    static int[] dist; // 최소거리 테이블
    static ArrayList<ArrayList<Node2>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 인접 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node2(v, w));
        }

        // 최소거리 테이블 초기화
        dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소비용만큼으로 우선순위를 설정한 우선순위 큐 생성 및 시작 노드 넣고 초기화
        PriorityQueue<Node2> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.offer(new Node2(c, 0));
        dist[c] = 0;

        while (!queue.isEmpty()) {
            Node2 tmp = queue.poll();

            // 필수조건
            // 현재 노드의 우선순위(비용)와 이미 최단 테이블에 저장된 우선순위(비용)보다 크다면 최소거리가 아니므로 갱신할 필요가 없기 떄문에 Pass
            if (tmp.cost > dist[tmp.nodeIdx]) {
                continue;
            }

            // 선택된 정점의 주변 정점 탐색 시작
            for (int i = 0; i < graph.get(tmp.nodeIdx).size(); i++) {
                Node2 nextNode = graph.get(tmp.nodeIdx).get(i);

                if (dist[nextNode.nodeIdx] > nextNode.cost + tmp.cost) {
                    dist[nextNode.nodeIdx] = nextNode.cost + tmp.cost;
                    queue.offer(new Node2(nextNode.nodeIdx, dist[nextNode.nodeIdx]));
                }
            }
        }

        int count = 0; // 메세지를 받게 되는 도시의 개수
        int maxDistance = 0; // 모두 메세지를 받기까지 걸리는 시간

        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                count++;
                maxDistance = Math.max(maxDistance, dist[i]);
            }
        }

        // 최초 노드를 제외하기 위해 count - 1
        System.out.println((count - 1) + " " + maxDistance);
    }
}

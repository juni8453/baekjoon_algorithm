package this_is_coding_test.shortest_path.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int nodeIdx;
    int cost;

    public Node(int nodeIdx, int cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}

public class Example {

    static int V,E, K;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 노드 인덱스
        E = Integer.parseInt(st.nextToken()); // 정점 갯수
        K = Integer.parseInt(br.readLine()); // 시작 노드

        // 정점 갯수만큼 그래프 노드 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()); // 노드 인덱스
            int w = Integer.parseInt(st.nextToken()); // 비용

            graph.get(u).add(new Node(v, w));
        }

        // 정점 카운터 초기화
        dist = new int[V + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소비용을 기준으로 잡은 우선순위 큐를 생성해 다익스트라 알고리즘 구현
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        // 시작 노드에서 가장 짧은 노드는 자기자신이고, 처음에는 시작 노드가 선택되므로 0으로 초기화
        queue.offer(new Node(K, 0));
        dist[K] = 0;

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            // 현재 노드의 비용(우선순위)가 최단거리 테이블[현재 노드의 인덱스] 보다 크다면 순회를 뛰어넘는다.
            if (tmp.cost > dist[tmp.nodeIdx]) {
                continue;
            }

            // 선택된 정점의 주변 정점을 검색한다.
            for (int i = 0; i < graph.get(tmp.nodeIdx).size(); i++) {
                Node nextNode = graph.get(tmp.nodeIdx).get(i);

                // 최단거리 테이블에서 이동하려는 노드의 인덱스 값이 현재 노드의 비용(우선순위) + 이동하려는 노드의 비용(우선순위) 보다
                // 크다면 최단거리가 아니므로 우선순위 큐에 (이동하려는 노드 인덱스, 최단거리 테이블[이동하려는 노드 인덱스]) 를 넣어준다.
                if (dist[nextNode.nodeIdx] > tmp.cost + nextNode.cost) {
                    dist[nextNode.nodeIdx] = tmp.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.nodeIdx, dist[nextNode.nodeIdx]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}

package baekjoongold.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int nodeIdx, cost;

    public Node(int nodeIdx, int cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}

public class 최단경로 {

    static int nodeIdx; // V
    static int edge; // E
    static int startNodeIdx; // K
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startNodeIdx = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < nodeIdx + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()); // 노드 인덱스
            int w = Integer.parseInt(st.nextToken()); // 비용

            graph.get(u).add(new Node(v, w));
        }

        // 최단거리 테이블 필요
        int[] distance = new int[nodeIdx + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 무한으로 초기화

        // 1. 최소 비용을 우선순위로 하는 우선순위 큐 생성 후 시작노드 0으로 초기화, 우선순위 큐에
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        q.offer(new Node(startNodeIdx, 0));
        distance[startNodeIdx] = 0;

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            // 2. 현재 노드의 비용이 최단거리 테이블에 갱신할 가치가 있는지 판단하고 더 크다면 (갱신 가치 X) 무시한다.
            if (tmp.cost > distance[tmp.nodeIdx]) {
                continue;
            }

            // 3. 선택된 노드 주변 노드를 탐색한다.
            for (int i = 0; i < graph.get(tmp.nodeIdx).size(); i++) {
                Node nextNode = graph.get(tmp.nodeIdx).get(i);

                // 3 - 1. 현재 노드 비용과 다음 노드 비용을 합한 값이 최단거리 테이블의 다음 노드 인덱스 값보다 작다면 갱신할 가치가 있다.
                if (distance[nextNode.nodeIdx] > tmp.cost + nextNode.cost) {
                    distance[nextNode.nodeIdx] = tmp.cost + nextNode.cost;
                    q.offer(new Node(nextNode.nodeIdx, distance[nextNode.nodeIdx]));
                }
            }
        }

        // 4. 최단거리 테이블 출력
        for (int i = 1; i <= nodeIdx; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}

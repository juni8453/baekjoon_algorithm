package baekjoongold.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node3 {
    int nodeIdx;
    int cost;

    public Node3(int nodeIdx, int cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}

public class 특정한_최단_경로 {

    static final int INF = (int) 1e9;
    static int nodeIdx;
    static int edge;
    static int startNodeIdx;
    static int endNodeIdx;
    static int v1;
    static int v2;
    static int[] distance;
    static ArrayList<ArrayList<Node3>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startNodeIdx = 1;
        endNodeIdx = nodeIdx;

        graph = new ArrayList<>();
        for (int i = 0; i < nodeIdx + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node3(v, w));
            graph.get(v).add(new Node3(u, w));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야 하는 nodeIdx 1
        v2 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야 하는 nodeIdx 2

        long path1 = dijkstra(1, v1);
        long path2 = dijkstra(1, v2);

        long path3 = dijkstra(v1, v2);
        long path4 = dijkstra(v2, v1);

        long path5 = dijkstra(v2, nodeIdx);
        long path6 = dijkstra(v1, nodeIdx);

        // v1 을 거치는 경로, v2 를 거치는 경로 확인 후 더 짧은 경로를 찾는다.
        long case1 = path1 + path3 + path5;
        long case2 = path2 + path4 + path6;

        // 아무런 경로가 없을 경우 Integer.MAX_VALUE 일꺼니까 그떄는 -1 출력
        if (case1 >= INF && case2 >= INF) {
            System.out.println(-1);

        } else {
            System.out.println(Math.min(case1, case2));
        }
    }

    private static int dijkstra(int startNodeIdx, int endNodeIdx) {
        // 다익스트라가 호출될 때마다 최단거리 테이블 초기화 필요.
        distance = new int[nodeIdx + 1];
        Arrays.fill(distance, INF);
        distance[startNodeIdx] = 0;

        PriorityQueue<Node3> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.offer(new Node3(startNodeIdx, 0));

        while (!q.isEmpty()) {
            Node3 tmp = q.poll();
            if (tmp.cost > distance[tmp.nodeIdx]) {
                continue;
            }

            for (int i=0; i<graph.get(tmp.nodeIdx).size(); i++) {
                Node3 nextNode = graph.get(tmp.nodeIdx).get(i);
                if (tmp.cost + nextNode.cost < distance[nextNode.nodeIdx]) {
                    distance[nextNode.nodeIdx] = tmp.cost + nextNode.cost;
                    q.offer(new Node3(nextNode.nodeIdx, distance[nextNode.nodeIdx]));
                }
            }
        }

        return distance[endNodeIdx];
    }
}

package baekjoongold.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node2 {
    int nodeIdx;
    int cost;

    public Node2(int nodeIdx, int cost) {
        this.nodeIdx = nodeIdx;
        this.cost = cost;
    }
}

public class 최소비용_구하기 {

    static int nodeIdx;
    static int edge;
    static int startNodeIdx;
    static int endNodeIdx;
    static int[] distance;
    static ArrayList<ArrayList<Node2>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeIdx = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < nodeIdx + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node2(v, w));
        }

        st = new StringTokenizer(br.readLine());
        startNodeIdx = Integer.parseInt(st.nextToken());
        endNodeIdx = Integer.parseInt(st.nextToken());

        distance = new int[nodeIdx + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNodeIdx] = 0;

        PriorityQueue<Node2> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.offer(new Node2(startNodeIdx, 0));

        while (!q.isEmpty()) {
            Node2 tmp = q.poll();
            if (tmp.cost > distance[tmp.nodeIdx]) {
                continue;
            }

            for (int i = 0; i < graph.get(tmp.nodeIdx).size(); i++) {
                Node2 nextNode = graph.get(tmp.nodeIdx).get(i);
                if (distance[nextNode.nodeIdx] > tmp.cost + nextNode.cost) {
                    distance[nextNode.nodeIdx] = tmp.cost + nextNode.cost;
                    q.offer(new Node2(nextNode.nodeIdx, distance[nextNode.nodeIdx]));
                }
            }


        }

        System.out.println(distance[endNodeIdx]);
    }
}

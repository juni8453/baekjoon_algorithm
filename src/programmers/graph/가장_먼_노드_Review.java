package programmers.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드_Review {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {
            {3, 6},
            {4, 3},
            {3, 2},
            {1, 3},
            {1, 2},
            {2, 4},
            {5, 2}
        };

        System.out.println(new Solution1_1().solution(n, vertex));
    }
}

class Solution1_1 {

    static int nodeIdx;
    static int edgeCount;
    static int[] counts;
    static boolean[] checked;
    static List<List<Integer>> graph = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        nodeIdx = n;
        edgeCount = edge.length;
        counts = new int[nodeIdx + 1];
        checked = new boolean[nodeIdx + 1];

        for (int i = 1; i <= nodeIdx + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 이차원 리스트로 양방향 그래프 구현
        for (int i = 0; i < edgeCount; i++) {
            int aNode = edge[i][0];
            int bNode = edge[i][1];

            graph.get(aNode).add(bNode);
            graph.get(bNode).add(aNode);
        }

        bfs(1);

        // counts = {0, 0, 1, 1, 2, 2, 2, 0, 0};
        // 가장 멀리 떨어진 노드는 4,5,6 번 노드
        int max = Integer.MIN_VALUE;
        for (int count : counts) {
            if (count > max) {
                max = count;
                answer = 1; // 최신 Max 값 나오면 다시 갱신

            } else if (count == max) {
                answer++;
            }
        }

        return answer;
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        checked[startNode] = true;

        while (!queue.isEmpty()) {
            Integer nowNode = queue.poll();
            for (int nextNode : graph.get(nowNode)) {
                if (!checked[nextNode]) {
                    checked[nextNode] = true;
                    queue.offer(nextNode);
                    counts[nextNode] = counts[nowNode] + 1;
                }
            }
        }
    }
}

// 1 ~ n 까지의 노드가 있고 1번 노드에서 가장 멀리 떨어진 노드를 구하려고 한다.
// 가장 멀리 떨어진 노드란, 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드를 뜻한다.

/**
 * 1 -> 2, 3
 * 2 -> 1, 3, 4, 5
 * 3 -> 1, 2, 4, 6
 * 4 -> 2, 3
 * 5 -> 2
 * 6 -> 3
 */
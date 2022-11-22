package programmers.graph;

import java.util.*;

public class 가장_먼_노드 {
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

        System.out.println(new Solution1().solution(n, vertex));
    }
}

class Solution1 {
    static int nodeIdx;
    static int edgeCount;
    static boolean[] checked;
    static int[] counts;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    // n 은 노드 갯수, edge[][] 는 간선 연결 정보
    public int solution(int n, int[][] edge) {
        int startNode = 1;
        nodeIdx = n;
        edgeCount = edge.length;
        checked = new boolean[n + 1];
        counts = new int[n + 1];

        for (int i = 0; i <= nodeIdx; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 이차원 리스트 셋팅
        for (int i = 0; i < edgeCount; i++) {
            int aNode = edge[i][0];
            int bNode = edge[i][1];

            graph.get(aNode).add(bNode);
            graph.get(bNode).add(aNode);
        }

        queue.offer(startNode);
        checked[startNode] = true;
        bfs();

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int cnt : counts) {
            if (max < cnt) {
                max = cnt;
                answer = 1; // 새로운 max 값이 나오면 다시 1로 초기화

            } else if (max == cnt) {
                answer++; // 같은 수가 나왔다면 거기서 계속 카운트
            }
        }

        return answer;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int nextNode : graph.get(nowNode)) {
                if (!checked[nextNode]) {
                    queue.offer(nextNode);
                    counts[nextNode] = counts[nowNode] + 1;
                    checked[nextNode] = true;
                }
            }
        }
    }
}

package programmers.brute_force;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {
    public static void main(String[] args) {
        int n3 = 7;
        int[][] wires3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};

        System.out.println(new Solution5().solution(n3, wires3));
    }
}

class Solution5 {

    static List<ArrayList<Integer>> map;
    static boolean[] checked;
    static int nodeIdx;
    static int edge;
    static int answer = Integer.MAX_VALUE;
    static int count;

    // n - 노드 갯수
    // wires.length = 간선 갯수
    public int solution(int n, int[][] wires) {
        map = new ArrayList<>();
        nodeIdx = n;
        edge = wires.length;
        checked = new boolean[n + 1];

        // 인접리스트 초기화
        for (int i = 0; i <= nodeIdx; i++) {
            map.add(new ArrayList<>());
        }

        // 인접 리스트 생성 (무방향 그래프)
        for (int i = 0; i < edge; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        // 간선 삭제 후 기준이 되는 두 개의 노드 중 하나를 선택해서 연결된 노드를 세준다.
        for (int[] wire : wires) {
            int leftNode = wire[0];
            int rightNode = wire[1];

            // 간선 삭제
            map.get(leftNode).remove((Integer)rightNode);
            map.get(rightNode).remove((Integer)leftNode);

            DFS(rightNode);

            int aNetwork = count;
            int bNetwork = n - count;
            int networkDeviceCount = Math.abs(aNetwork - bNetwork);
            answer = Math.min(answer, networkDeviceCount);

            // 간선 복구
            map.get(leftNode).add(rightNode);
            map.get(rightNode).add(leftNode);
            checked = new boolean[nodeIdx + 1];
            count = 0;
        }

        return answer;
    }

    private static void DFS(int startNode) {
        checked[startNode] = true;
        count++;

        for (int nextNode : map.get(startNode)) {
            if (!checked[nextNode]) {
                checked[nextNode] = true;
                DFS(nextNode);
                checked[nextNode] = false;
            }
        }
    }
}

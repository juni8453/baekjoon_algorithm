package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdjacencyList {
    static int answer = 0;
    static int nodeIdx;
    static int edge;
    static int[] checkArr;
    static ArrayList<ArrayList<Integer>> graph;

    public static void DFS(int v) { // v = 탐색 시작 노드
        if (v == nodeIdx) {
            answer++;
        } else {
            // v 노드와 연결되어 있는 노드를 찾고 방문 표시가 없는지 확인한다.
            // 인접행렬과는 다르게 방문했는지 안했는지만 확인하면 된다.
            // nv 가 현재 v 노드와 연결되어있는 인접 노드들이라고 할 수 있겠다.
            for (int nv : graph.get(v)) {
                if (checkArr[nv] == 0) {
                    checkArr[nv] = 1;
                    DFS(nv);
                    checkArr[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= nodeIdx; i++) { // nodeIdx=5 라면 0,1,2,3,4,5 까지 List 생성
            graph.add(new ArrayList<Integer>());
        }
        checkArr = new int[nodeIdx + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }
        checkArr[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}

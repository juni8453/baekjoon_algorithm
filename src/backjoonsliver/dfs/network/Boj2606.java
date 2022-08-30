package backjoonsliver.dfs.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2606 {
    static int answer;
    static int nodeIdx;
    static int edge;
    static int[] check;
    static List<ArrayList<Integer>> graph;

    // 이 문제에서는 하나의 노드를 기준으로 잡고 해당 노드에 걸쳐져있는 노드들만 검사하면 되기 때문에
    // 굳이 check 배열을 다시 풀어줄 필요는 없다.
    public static void DFS(int v) {
        check[v] = 1; // 방문 표시 해주고,

        for (int nv : graph.get(v)) { // 해당 노드에 연결된 인접 노드들을 하나씩 검사한다.
            if (check[nv] == 0) { // 방문하지 않은 노드가 있다면,
                answer++; // 연결되어있기 때문에 바이러스 감염 컴퓨터 댓수를 추가
                DFS(nv); // 연쇄 감염을 확인하기 위해 재귀 호출을 실시
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeIdx = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        check = new int[nodeIdx + 1];

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= nodeIdx; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        check[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}

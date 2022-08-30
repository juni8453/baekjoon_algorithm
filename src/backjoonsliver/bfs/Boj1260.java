package backjoonsliver.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {
    static int nodeIdx;
    static int edge;
    static int v;
    static int[] check;
    static ArrayList<ArrayList<Integer>> list;

    static void DFS(int v) {
        check[v] = 1;
        System.out.print(v + " ");

        for (int nv : list.get(v)) {
            if (check[nv] == 0) {
                check[nv] = 1;
                DFS(nv);
            }
        }
    }

    static void BFS() {
        check[v] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // 해당 노드의 자식 노드만큼만 반복
            for (int childNode : list.get(node)) {
                if (check[childNode] == 0) {
                    queue.offer(childNode);
                    check[childNode] = 1;
                }
            }
        }
    }

    // 인접 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        check = new int[1001];
        list = new ArrayList<>();

        for (int i = 0; i <= nodeIdx; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list.get(a).add(b);
            list.get(b).add(a); // 양방향
        }

        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i)); // 방문할 정점의 수가 여럿이면 번호가 작은 것 부터 방문하기 위해 정렬
        }

        DFS(v); // 시작 노드는 v 부터
        System.out.println();
        Arrays.fill(check, 0);
        BFS();
    }
}

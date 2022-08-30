package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Section0708 {
    static int[] dis;
    static int[] check;
    static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dis = new int[]{1, -1, 5};
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int result = BFS(S, E);
        System.out.println(result);
    }

    public static int BFS(int S, int E) {
        check = new int[10001];
        check[S] = 1; // 출발 노드 (루트 노드)
        Q.offer(S);

        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll(); // 자식 노드를 구하기 위해 노드를 꺼낸다.

                for (int j = 0; j < dis.length; j++) { // dis[] = {1, -1, 5}
                    int nx = x + dis[j];
                    if (nx == E) {
                        return level + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && check[nx] == 0) { // nx가 범위 내에 있고, 노드에 방문 체크가 안되있다면
                        check[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }

            level++;
        }
        return 0;
    }
}

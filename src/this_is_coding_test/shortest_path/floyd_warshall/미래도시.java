package this_is_coding_test.shortest_path.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래도시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 987_654_321); // 대략 10억
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // k <= N 또는 k < N + 1 가능
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // 1번회사에서 K번 회사까지의 시간 + K번 회사를 거쳐 X번 회사까지의 시간
        long distance = map[1][K] + map[K][X];

        if (distance >= 987_654_321) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}

// K번 회사를 거쳐 X번 회사로 가는 최소 이동시간을 출력한다.
// 만약 X번 회사에 도달할 수 없다면 -1을 출력한다.

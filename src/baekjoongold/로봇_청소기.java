package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_청소기 {

    static int n, m, r, c, d, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 1. Map 만들기
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c);
        System.out.println(count);
    }

    // 빈 칸 0, 벽 1
    private static void dfs(int x, int y) {
        if (map[x][y] == 0) {
            count++;
            map[x][y] = -1;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 왼쪽 방향이 벽이 아니며 청소를 하지 않은 경우에는 그 방향으로 회전한 뒤 다음 한 칸을 전진하고 전진한 해당 칸을 청소한다.
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                map[nx][ny] = -1;
                count++;
                dfs(nx, ny);

                // 한 방향으로 쭉 청소를 한 뒤 후진으로만 돌아가려면 다시 dfs 재귀를 돌지 않기 위해 return 을 추가해준다.
                return;
            }
        }

    // 모든 방향을 탐색해도 갈 곳이 없다면 후진해야 한다.
    // 후진 공식 : (d + 2) % 4;
        int back = (d + 2) % 4;
        int nx = dx[back] + x;
        int ny = dy[back] + y;

        // 후진을 할려고 할 떄, 모두 청소가 되어있거나 벽이면서 후진 방향 또한 벽일 떄 작동을 멈춘다.
        if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1) {
            dfs(nx, ny);
        }
    }
}

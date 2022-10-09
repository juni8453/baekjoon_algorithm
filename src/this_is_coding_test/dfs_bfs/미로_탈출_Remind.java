package this_is_coding_test.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 미로_탈출_Remind {

    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] dis;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];
        checked = new boolean[n][m];

        // 1. map 채워넣기.
        for (int i = 0; i < n; i++) {
            String[] inputLine = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        // 2. 시작 지점은 항상 1이기 때문에 미리 초기화
        dis[0][0] = 1;

        // 3. map 한 행씩 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !checked[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(dis[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<Point2> q = new LinkedList<>();
        q.offer(new Point2(x, y));

        while (!q.isEmpty()) {
            Point2 tmp = q.poll();

            // 4방향 벡터 사용
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && !checked[nx][ny]) {
                    checked[nx][ny] = true;
                    q.offer(new Point2(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}

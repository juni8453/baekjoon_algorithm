package backjoonsliver.bfs;

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

public class 토마토 {
    static int n;
    static int m;
    static int count;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] dis;
    static Queue<Point2> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];

        // 1. 최초 맵 생성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 익은 토마토 찾아서 Queue 에 미리 삽입
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.offer(new Point2(i, j));
                }

            }
        }

        BFS();

        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    count = Math.max(count, dis[i][j]);
                }
            }
        }
        System.out.println(count);
    }

    private static void BFS() {
        while (!q.isEmpty()) {
            Point2 tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = 1; // 체크 표시 (익은걸로 표시)
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    q.offer(new Point2(nx, ny));
                }
            }
        }
    }
}

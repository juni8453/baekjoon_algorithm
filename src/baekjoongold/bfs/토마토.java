package baekjoongold.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 토마토 {

    static int n, m;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] dis;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1); // 토마토가 다 익지 못했으므로 -1 출력 후 종료
                    return;
                } else {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }

        System.out.println(answer);

    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}

// 익은 토마토 1, 안익은 토마토 0, 토마토가 없는 칸 -1
// 1 기준 동서남북으로 0이 있다면 하루 지나서 1로 바뀐다.

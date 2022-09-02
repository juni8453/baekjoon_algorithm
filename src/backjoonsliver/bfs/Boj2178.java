package backjoonsliver.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] dis;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        map[1][1] = 1; // 최초 (1,1) 초기화
        BFS();

        // 시작 위치 또한 포함하기 때문에 + 1
        System.out.println(dis[N][M] + 1);
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1));

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= N && ny <= M && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}

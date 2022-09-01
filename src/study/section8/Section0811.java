package study.section8;

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

public class Section0811 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static int[][] map = new int[8][8];
    static int[][] dis = new int[8][8]; // map 과 똑같은 배열 하나 더 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 7;
        M = 7;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();

        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1));
        map[1][1] = 0;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            for (int i = 0; i < 4; i++) { // 4방향 확인
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <=7 && map[nx][ny] == 0) { // 경로 이동이 가능한지 확인
                    map[nx][ny] = 1; // check
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 다음 위치는 현재 위치에서 +1 된 값을 넣어줘야 한다.
                }
            }
        }
    }
}

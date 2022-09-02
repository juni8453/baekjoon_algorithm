package study.section8;

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

public class Section0812 {
    static int n;
    static int m;
    static int day;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static int[][] dis;
    static Queue<Point2> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토의 시작 위치를 찾아 해당 좌표를 먼저 큐에 넣는다.
                // 익은 토마토 위치가 하나가 아니니까 먼저 넣어줘서 큐를 돌리기 위함
                if (board[i][j] == 1) {
                    q.offer(new Point2(i, j));
                }
            }
        }

        BFS();

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) { // BFS 가 종료된 후에도 익지 않은 토마토가 있다면 ?
                    flag = false;
                }
            }
        }

        if (flag) { // 익지 않은 경우가 존재하지 않는다면 ?
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    day = Math.max(day, dis[i][j]);
                }
            }
            System.out.println(day);
        } else { // 익지 않는 경우가 존재한다면 ?
            System.out.println(-1);
        }
    }

    private static void BFS() {
        while (!q.isEmpty()) {
            Point2 goodTomatoPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = goodTomatoPoint.x + dx[i];
                int ny = goodTomatoPoint.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1; // 익은 걸로 표시
                    q.offer(new Point2(nx, ny));
                    dis[nx][ny] = dis[goodTomatoPoint.x][goodTomatoPoint.y] + 1;
                }
            }
        }
    }
}

// 상,하,좌,우에 익은 토마토가 있다면 하루가 지났을 때 토마토가 익게 된다.
// 몇일이 자나면 토마토가 전부 다 익게되는지 최소 일수를 구해라.
// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 없는 경우
// 모든 토마토가 익어있다면 0 출력, 모두 익지는 못하면 -1 출력
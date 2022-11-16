package this_is_coding_test.prctice.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
    int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 연구소 {

    static int n, m;
    static int maxSafeZoneCount = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] checked;
    static Queue<Point2> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        checked = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

//                if (map[i][j] == 2) {
//                    queue.offer(new Point2(i, j)); // 바이러스를 찾아 큐에 삽입
//                }
            }
        }

        dfs(0);
        System.out.println(maxSafeZoneCount);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        // 0 = 빈칸, 1 = 벽, 2 = 바이러스
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) { // 빈 칸이라면 벽을 세워주자.
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // bfs 를 통해 바이러스를 퍼뜨린다.
    private static void bfs() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Point2(i, j));
                }
            }
        }

        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int copyMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            Point2 point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && copyMap[nx][ny] == 0) {
                    queue.offer(new Point2(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }

        checkSafeZone(copyMap);
    }

    private static void checkSafeZone(int[][] copyMap) {
        int safeZoneCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeZoneCount++;
                }
            }
        }

        maxSafeZoneCount = Math.max(maxSafeZoneCount, safeZoneCount);
    }
}

// 바이러스는 상하좌우로 퍼질 수 있다.
// 새로운 벽을 3개 설치할 수 있는데, 적절히 설치해서 바이러스의 전염을 막고 안전지대를 구해내라.

/**
 - 1번 예시 Input
 - 최대한 바이러스 전염을 막기 위해선, 벽을 통해 바이러스를 격리시켜야 한다.
 2 0 0 0 1 1 0
 0 0 1 0 1 2 0
 0 1 1 0 1 0 0
 0 1 0 0 0 0 0
 0 0 0 0 0 1 1
 0 1 0 0 0 0 0
 0 1 0 0 0 0 0

 2 1 0 0 1 1 0
 1 0 1 0 1 2 0
 0 1 1 0 1 0 0
 0 1 0 0 1 0 0
 0 0 0 0 0 1 1
 0 1 0 0 0 0 0
 0 1 0 0 0 0 0
 */
package this_is_coding_test.prctice.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y, cost, time;

    public Point(int x, int y, int cost, int time) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.time = time;
    }
}

public class 경쟁적_전염 {

    static int n, k, s, x, y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행, 열
        k = Integer.parseInt(st.nextToken()); // 바이러스의 갯수
        map = new int[n][n];

        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();

        // 맵 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new Point(i, j, map[i][j], 0));
                }
            }
        }

        // 한번 정렬해서 큐에 넣어주면 bfs 동작 과정에서 어짜피 낮은 번호의 바이러스가 계속해서 앞에 삽입되기 때문에 따로 정렬해서 넣을 필요가 없다.
        list.sort(Comparator.comparingInt(o -> o.cost));

        for (Point point : list) {
            queue.offer(point);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bfs(queue);
        System.out.println(map[x - 1][y - 1]);
    }

    private static void bfs(Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();

            if (nowPoint.time == s) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + nowPoint.x;
                int ny = dy[i] + nowPoint.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0) {
                    map[nx][ny] = nowPoint.cost;
                    queue.add(new Point(nx, ny, nowPoint.cost, nowPoint.time + 1));
                }
            }
        }
    }
}


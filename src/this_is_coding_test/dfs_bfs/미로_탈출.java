package this_is_coding_test.dfs_bfs;

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

public class 미로_탈출 {

    static int answer;
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

        // 1. Map 파싱받기
        for (int i = 0; i < n; i++) {
            String[] inputLine = new StringTokenizer(br.readLine()).nextToken().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        // 2. dis[0][0] 출발지점 1로 초기화
        dis[0][0] = 1;

        // 3. 2차원 배열의 행을 차례대로 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !checked[i][j]) {
                    BFS();
                }
            }
        }

        // 4. dis 도착지점 값 출력
        System.out.println(dis[n - 1][m - 1]);
    }

    private static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        while(!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + point.x;
                int ny = dy[i] + point.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && !checked[nx][ny]) {
                    checked[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[point.x][point.y] + 1;
                }
            }
        }
    }
}

// 미로를 탈출하는 최소 칸의 갯수를 구하는 프로그램 작성
// 칸을 셀 떄는 첫 칸과 마지막 칸을 포함에서 세야한다.
// 시작 칸과 마지막 칸은 항상 통로(1) 이다.
// 괴물이 있는 경우 0, 없는 통로는 1로 정의

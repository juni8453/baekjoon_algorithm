package this_is_coding_test.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수_얼려_먹기_Remind {

    static int n;
    static int m;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        checked = new boolean[n][m];

        // 1. 입력 값으로 Map 만들기
        for (int i = 0; i < n; i++) {
            String[] inputLine = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        // 2. Map 을 한 행씩 확인하며 탐색
        for (int i = 0; i < n; i++) {
            // 원소가 0이고 방문하지 않았을 경우,
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !checked[i][j]) {
                    count++;
                    checked[i][j] = true;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        // 4방향 벡터 사용
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}

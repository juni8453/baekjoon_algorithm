package backjoonsliver.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 유기농_배추 {

    static int n;
    static int m;
    static int k;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        for (int a = 0; a < testCount; a++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            k = Integer.parseInt(st.nextToken()); // 배추 갯수
            map = new int[n][m];
            checked = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], 0);
            }

            // 1. map 채우기.
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            // 2. 2차원 배열 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !checked[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;
        }

    }

    private static void dfs(int x, int y) {
        checked[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}

// 각 테스트 케이스에 필요한 최소의 배추흰지렁이 마리수를 구하시오.
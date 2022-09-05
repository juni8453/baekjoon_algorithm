package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식물_피하기_Review {
    static int n;
    static int m;
    static int k;
    static int count;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        // 쓰레기 먼저 배치
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 1은 쓰레기, 0은 통로
            map[x - 1][y - 1] = 1;
        }

        // 쓰레기가 아닌 곳 통로로 배치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 1) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    // 어느 부분이 제일 많이 뭉쳐있는지 확인하는 이런 문제 유형에서는 항상 count 초기 값을 유의하자.
                    // 쓰레기가 있을 때를 조건에 걸었기 때문에 무조건 쓰레기가 최소 한 개는 있는거니까 count = 1 초기화
                    count = 1;
                    DFS(i, j);
                    answer = Math.max(count, answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                count++;
                DFS(nx, ny);
            }
        }
    }
}

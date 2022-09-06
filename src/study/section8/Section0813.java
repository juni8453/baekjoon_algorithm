package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0813 {

    static int answer = 0;
    static int n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 1. 전체 맵 Setting
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2중 반복문으로 DFS 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 1이면 육지 = 섬 이기 때문에 바로 카운팅
                if (map[i][j] == 1) {
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void DFS(int x, int y) {
        map[x][y] = 0; // 방문 check

        // 대각선 허용이기 때문에 8방향 벡터 설정
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1) {
                map[nx][ny] = 0; // 다음 경로 방문 check
                DFS(nx, ny);
            }
        }
    }
}

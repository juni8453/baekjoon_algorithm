package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 섬의_개수 {

    static int h;
    static int w;
    static int count = 0;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];

            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        DFS(i, j);
                    }
                }
            }

            System.out.println(count);
            count = 0;
        }
    }

    private static void DFS(int x, int y) {
        map[x][y] = 0; // 방문 체크

        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] == 1) {
                map[nx][ny] = 0; // 이동 시 방문 체크
                DFS(nx, ny);
            }
        }
    }
}

// 1 = 땅, 0 = 바다
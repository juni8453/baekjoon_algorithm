package this_is_coding_test.dfs_bfs;

import studyReview.DFS.DFS0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수_얼려_먹기 {

    static int answer;
    static int n;
    static int m;
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

        // 1. 맵 만들기
        for (int i = 0; i < n; i++) {
            String[] inputLine = new StringTokenizer(br.readLine()).nextToken().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        // 2. 2차원 배열을 행 단위로 차례대로 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !checked[i][j]) {
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
}

// 첫 번째 줄에 얼음 틀의 세로 길이 N(행)과 가로 길이 M(열)이 주어진다.
// 두 번째 줄부터 얼음 틀의 형태가 주어진다.
/*
* 00110
* 00011
* 11111
* 00000
* */
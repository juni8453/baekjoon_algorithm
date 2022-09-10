package mockexam.Day0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전쟁_전투 {

    static int m;
    static int n;
    static int count;
    static int wCount;
    static int bCount;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visited = new boolean[n][m];

        // 초기 맵 설정
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
            }
        }

        // 2중 for문으로 맵을 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String teamColor = map[i][j];

                // 방문이 안된 곳, 같은 팀일 경우에 탐색
                if (!visited[i][j]) {
                    visited[i][j] = true; // 방문 check
                    count = 0; // 서로 카운팅 섞이지 않도록 여기서 초기화
                    DFS(i, j, teamColor);

                    if (teamColor.equals("W")) {
                        wCount += count * count;
                    } else {
                        bCount += count * count;
                    }
                }
            }
        }

        System.out.print(wCount + " " + bCount);

    }

    private static void DFS(int x, int y, String teamColor) {
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny].equals(teamColor)) {
                visited[nx][ny] = true; // 이동 방향에 방문표시
                DFS(nx, ny, teamColor);
            }
        }
    }
}

// 대각은 인정하지 않는다. 방향벡터 4방향 적용
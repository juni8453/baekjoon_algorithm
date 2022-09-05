package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전쟁_전투_Review {
    static int n;
    static int m;
    static int count;
    static int wCount;
    static int bCount;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visited = new boolean[n][m];

        // 1. 초기 맵 설정
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
            }
        }

        // 2. DFS 호출 전 판단 (좌표 상 방문했는지, 팀 컬러는 무엇인지 ?)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    String color = map[i][j];

                    // 2-1. W 에서 B 로 넘어가서 병사 세줄 때 초기화 필요
                    count = 0;
                    DFS(i, j, color);

                    if (color.equals("W")) {
                        wCount += count * count;
                    }

                    if (color.equals("B")) {
                        bCount += count * count;
                    }
                }
            }
        }
        System.out.println(wCount + " " + bCount);
    }

    private static void DFS(int x, int y, String color) {
        // 3. 해당 좌표 방문체크
        visited[x][y] = true;
        count++;

        // 4. 방향 벡터 사용
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 4-1 방문하지 않은 곳인지, 팀 컬러가 일치하는지 체크
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny].equals(color)) {
                visited[nx][ny] = true;
                DFS(nx, ny, color);
            }
        }
    }
}

package backjoonsliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 양 {

    static int R, C;
    static int totalWolf = 0;
    static int totalShip = 0;
    static int wolf = 0;
    static int ship = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];

        // 맵 셋팅
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                wolf = 0;
                ship = 0;

                // 방문하지 않은 곳에 늑대, 양이 발견될 경우 탐색 시작
                if (!visited[i][j]) {
                    if (map[i][j].equals("v") || map[i][j].equals("o")) {
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }

                if (ship > wolf) {
                    wolf = 0;

                } else {
                    ship = 0;
                }

                totalWolf += wolf;
                totalShip += ship;
            }
        }

        System.out.println(totalShip + " " + totalWolf);
    }

    private static void dfs(int x, int y) {
        if (map[x][y].equals("o")) {
            ship++;

        } else if (map[x][y].equals("v")) {
            wolf++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 맵 안쪽인지, 울타리 안인지 확인
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && !map[nx][ny].equals("#")) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}

// 영역 안의 늑대 수 < 양 수 라면, 해당 구역의 양은 살아남는다.
// 그렇지 않다면 해당 구역의 양은 모두 사라진다.
// 아침이 도달했을 때, 살아남은 양과 늑대의 수를 출력하는 프로그램을 작성해라.

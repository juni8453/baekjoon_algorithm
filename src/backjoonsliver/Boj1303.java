package backjoonsliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Boj1303 {
    static int N;
    static int M;
    static int count;
    static int white_count = 0;
    static int blue_count = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // M 을 가로, N 을 세로로 받을 수 있도록 위치 바꿔치기
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 방문표시 안된 곳만 탐색해야하기 때문에
                if (!visited[i][j]) {
                    String color = map[i][j];
                    count = 0;
                    DFS(i, j, color);

                    // 우리팀
                    if (color.equals("W")) {
                        white_count += count * count;
                    // 적팀
                    } else {
                        blue_count += count * count;
                    }
                }
            }
        }

        System.out.print(white_count + " " + blue_count);
    }

    private static void DFS(int x, int y, String color) {
        visited[x][y] = true; // check
        count++;

        // 방향 벡터를 통해 4방향으로도 아무데도 갈 곳이 없다면 뭉쳐져있는 해당 팀 컬러의 사람 수가 나온다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 존재하면서 받아온 팀 컬러와 일치하는지, 방문하지 않았는지 체크
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny].equals(color) && !visited[nx][ny]) {
                DFS(nx, ny, map[nx][ny]);
            }
        }
    }
}

// N 명이 뭉쳐잇을떄는 N^2 의 위력을 낸다. 대각선은 뭉쳐있지 않다고 본다.
// 우리팀과 적팀의 위력을 출력하자.

// 예제에서는 9명^2 + 7명^2 = 130 / 1 + 8명^2 = 65
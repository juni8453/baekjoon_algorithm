package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1743 {
    static int N;
    static int M;
    static int K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        // 쓰레기 있는 곳 1로 해서 먼저 생성
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        // 전체 map 생성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != 1) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 방문 표시 안되있는 곳이면서 쓰레기일 때
                // 이떄 주위의 쓰레기를 탐색해서 뭉쳐있는 수가 가장 많을 떄를 찾아내야 한다.
                if(!visited[i][j] && map[i][j] == 1) {
                    count = 1;
                    DFS(i, j);
                    answer = Math.max(answer, count); // 어느 지점이 가장 많이 뭉쳐있는지 판단하기 위함
                }
            }
        }

        System.out.println(count);
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true; // check

        // 주위의 쓰레기를 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 방문하지 않았고 현재 위치가 쓰레기인 경우만 탐색
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                count++;
                DFS(nx, ny);
                // 최대 경로를 뽑는 문제가 아니기 때문에 좌표 check 를 다시 복구할 필요는 없다.
            }
        }
    }
}

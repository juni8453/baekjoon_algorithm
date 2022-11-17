package backjoonsliver.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열_돌리기_Remind {

    static int n, m, r;
    static int[] dx = {0, 1, 0, -1}; // 반시계 방향으로 숫자를 옮기기 위해 시계 방향으로 라인을 탐색하면서 반시계 방향으로 서로 숫자를 변경한다.
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // 2차원 배열 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 반복문을 통해 배열 돌리기 1차는 돌려야하는 횟수, 2차는 라인 갯수만큼 반복하도록 설정한다.
        // 먼저 해당 배열은 몇 개의 라인이 있는지 구한다. n, m 중 더 작은 값에서 /2 한 값이 배열에서 돌려야하는 라인의 갯수.

        int lineCount = Math.min(n, m) / 2;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < lineCount; j++) {
                int x = j;
                int y = j;

                int stock = map[x][y];
                int direction = 0;

                // 4방향 벡터 설정
                while (direction < 4) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];

                    // 라인을 내부에 있는지, 넘어가는지 체크 (j가 현재 라인이 될 것)
                    if (nx >= j && ny >= j && nx < n - j && ny < m - j) {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;

                    // 라인 내부에 없고 넘어간다면 해당 방향은 종료
                    } else {
                        direction++;
                    }
                }

                map[j + 1][j] = stock;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }
    }
}

// 2차원 배열 반시계 방향으로 돌리기.
// dx[], dy[] 배열을 반시계 방향으로 돌아가게 설정한다.
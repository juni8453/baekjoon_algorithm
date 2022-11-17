package backjoonsliver.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열_돌리기1 {

    static int[] dx = {0, 1, 0, -1}; // 반시계 방향으로 숫자를 옮기기 위해 시계 방향으로 라인을 탐색하면서 반시계 방향으로 서로 숫자를 변경한다.
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 반시계 방향으로 몇 번 회전하는지 ?

        // 돌릴 배열 셋팅
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 돌려야하는 그룹 개수 구하기
        int group_value = Math.min(n, m) / 2;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < group_value; j++) {
                int x = j;
                int y = j;

                int value = map[x][y];
                int idx = 0; // 방향

                while (idx < 4) { // 4방향을 모두 돌았다면 해당 라인 돌리기에서 빠져나간다.
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    // 돌려야하는 각 라인 내에서 넘어가지 않게 돌려주기 위해 분기문 설정
                    if (nx >= j && ny >= j && nx < n - j && ny < m - j) {
                        map[x][y] = map[nx][ny]; // 라인의 현재 위치 바로 뒤의 숫자를 복사해 넣어준다.
                        x = nx; // 재귀가 아니기 때문에 x, y 값을 갱신해줘야한다.
                        y = ny;

                    } else {
                        idx++; // 각 라인을 넘어간다면 방향 수정
                    }
                }

                map[j + 1][j] = value;
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

// 배열과 정수 R이 주어졌을 떄, 배열을 R번 회전시킨 결과를 구해라.
// 먼저 돌려야하는 그룹 개수를 구한다. 그룹 개수는 n,m 중 최소값에서 /2 하면 나옴.

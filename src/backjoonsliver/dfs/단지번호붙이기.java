package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {

    static int n; // 정사각형
    static int answer;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] checked;
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 2차원 배열 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !checked[i][j]) {
                    dfs(i, j);
                    answer++;
                    answers.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(answers);
        System.out.println(answer);
        for (int i : answers) {
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y) {
        checked[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !checked[nx][ny] && map[nx][ny] == 1) {
                checked[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}

// 집 있는 곳 1, 집 없는 곳 0, 상하좌우로 집이 있는 것을 연결되었다고 한다. (대각선은 X)
// 각 단지에 속하는 집의 수를 오름차순으로 정렬해 출력하는 프로그램을 작성하시오.
package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0710 {

    static int[][] map;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void DFS(int x, int y) {
        // 모든 경우의 수를 탐색해야하기 때문에 if-else 사용
        if (x == 7 && y == 7) { // 도착지점에 도달한 경우
            answer++; // 경우의 수 하나 증가
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0) { // 갈 수 있는 경로인지 확인
                    map[nx][ny] = 1;
                    DFS(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[7 + 1][7 + 1];

        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[1][1] = 1; // 시작하기 전에 바로 check
        DFS(1, 1);
        System.out.println(answer);
    }
}

// 미로 탐색 (DFS)
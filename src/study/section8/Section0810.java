package study.section8;

import java.util.Scanner;

public class Section0810 {
    static int answer;
    static int[] dx = {-1, 0, 1, 0}; // 9시, 12시, 3시, 6시 방향 순으로
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[7 + 1][7 + 1];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        map[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }

    private static void DFS(int x, int y) {
        // 도착지점에 왔을 때 탈
        if (x == 7 && y == 7) {
            answer++;
        } else {
            // 4방향으로 판단해야하니까
            for (int i = 0; i < 4; i++) {
                // 타고나갈 방향 설정
                int nx = x + dx[i]; // dx = {-1, 0, 1, 0}  nx = 1
                int ny = y + dy[i]; // dy = {0, 1, 0, -1}  ny = 2
                // 경계선 밖인지, 통로인지 판단 (행, 열 모두 판단)
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    DFS(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }
}

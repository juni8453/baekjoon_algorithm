package groom.week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 단풍나무 {

    static int n;
    static int count;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] todayMap;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        todayMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);

                if (map[i][j] > 0) {
                    q.offer(new Point(i, j));
                }
            }
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        int checkSize = q.size();

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            checkSize--;

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0) {
                    count++;
                }
            }

            // 자신의 좌표 값에서 count 를 뺀 값을 좌표 값으로 갱신한다.
            // 단, 자신의 좌표 값보다 count 수가 많거나 같다면 바로 0 으로 변환 처리한다.
            // 주위에 물든 나무가 아무것도 없는 count == 0 인 경우, 넘어가도록 한다.

            if (map[tmp.x][tmp.y] >= count) {
                todayMap[tmp.x][tmp.y] = map[tmp.x][tmp.y] - count;
                if (todayMap[tmp.x][tmp.y] != 0) {
                    q.offer(new Point(tmp.x, tmp.y));
                }
                count = 0;

            } else if (map[tmp.x][tmp.y] < count) {
                todayMap[tmp.x][tmp.y] = 0;
                count = 0;

            } else if (count == 0) {
                continue;
            }

            if (checkSize == 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        map[i][j] = todayMap[i][j];
                    }
                }

                answer++;
                checkSize = q.size();
            }
        }
    }
}

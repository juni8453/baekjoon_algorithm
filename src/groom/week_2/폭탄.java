package groom.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 폭탄 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정사각형 한 변의 길이
        int k = Integer.parseInt(st.nextToken()); // 폭탄의 갯수
        int[][] map = new int[n + 1][n + 1];

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        for (int i = 0; i < k; i++) {
            int x = points.get(i).x;
            int y = points.get(i).y;
            map[x][y]++;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx > 0 && ny > 0 && nx <= n && ny <= n) {
                    map[nx][ny]++;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) {
                    sum += map[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}

// 모든 폭탄이 떨어졌을 떄, 정사각형 내의 모든 폭탄 값을 합한 값을 구하시오.
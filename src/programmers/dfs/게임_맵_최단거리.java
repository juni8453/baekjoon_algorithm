package programmers.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        int[][] maps = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1}
        };

        System.out.println(new Solution2().solution(maps));
        System.out.println(new Solution2().solution(maps2));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution2 {

    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] DIS;
    static boolean[][] checked;

    public int solution(int[][] maps) {
        int answer = 0;
        int nCount = 0;
        int mCount = 0;

        for (int i = 0; i < maps.length; i++) {
            nCount = i;
            for (int j = 0; j < maps[i].length; j++) {
                mCount = j;
            }
        }

        n = nCount + 1;
        m = mCount + 1;

        DIS = new int[n][m];
        checked = new boolean[n][m];

        DIS[0][0] = 1;
        checked[0][0] = true; // DIS, checked 배열 초기화 (1,1 에서 시작하기 때문)

        BFS(maps);

        answer = DIS[nCount][mCount];

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    private void BFS(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !checked[nx][ny] && maps[nx][ny] == 1) {
                    checked[nx][ny] = true;
                    DIS[nx][ny] = DIS[tmp.x][tmp.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}

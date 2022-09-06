package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

public class Boj15686 {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int len;
    static int[] combi;
    static int[][] map;
    static List<Point> homes = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m]; // 하나의 조합을 모아두는 배열
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new Point(i, j));
                } else if (num == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        len = chickens.size();
        DFS(0, 0);
        System.out.println(answer);

    }

    // 조합의 공식 사용
    private static void DFS(int depth, int startNode) {
        if (depth == m) {
            // 하나의 집을 기준으로 살아남은 치킨집과의 거리를 구해서 모두 더해준다. (도시의 치킨 거리를 구해주는 것)
            int sum = 0;
            for (Point home : homes) { // 기준 집
                int dis = Integer.MAX_VALUE;
                for (int i : combi) { // 살아남은 치킨 집들 (하나의 조합) 과 비교
                    // 기준 집과 가장 거리가 짧은 치킨집과의 거리는 ?
                    dis = Math.min(dis, Math.abs(home.x - chickens.get(i).x) + Math.abs(home.y - chickens.get(i).y));
                }
                sum += dis; // 살아남은 치킨집들의 각 조합과 기준 집에서의 거리를 모두 합한 값 = 치킨 거리
            }
            answer = Math.min(answer, sum); // 이제 각 조합의 치킨 거리 중 가장 짧은 치킨 거리를 구해주면 된다.

        } else {
            for (int i = startNode; i < len; i++) {
                combi[depth] = i;
                DFS(depth + 1, i + 1);
            }
        }
    }
}

// 각 집에서 가장 가까운 치킨집 거리를 모두 더한 값 = 도시의 치킨 거리
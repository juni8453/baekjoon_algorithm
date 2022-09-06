package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point2 {
    int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 치킨_배달_거리_Review {

    static int n;
    static int m;
    static int pizzaHomesCount;
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point2> homes = new ArrayList<>();
    static List<Point2> pizzas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 1) {
                    homes.add(new Point2(i, j));
                } else if (number == 2) {
                    pizzas.add(new Point2(i, j));
                }
            }
        }

        pizzaHomesCount = pizzas.size();
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int depth, int start) {
        // m 개의 원소갯수를 갖는 선택된 피자집들의 조합이 만들어진 상황
        if (depth == m) {
            int sum = 0;

            for (Point2 home : homes) {
                int dis = Integer.MAX_VALUE; // 한 집 한 집 초기화 되면서 자신의 집 피자 거리를 구해야하기 때문에 for 안에 설정
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(home.x - pizzas.get(i).x) + Math.abs(home.y - pizzas.get(i).y));
                }
                sum += dis;
            }

            answer = Math.min(answer, sum);

        } else {
            for (int i = start; i < pizzaHomesCount; i++) {
                combi[depth] = i;
                DFS(depth + 1, i + 1);
            }
        }
    }
}

// 각 집의 피자 배달거리는 해당 집과, 도시에 존재하는 피자집들과의 거리 중 가장 짧은 거리를 뜻한다.
// 도시의 피자 배달거리는 모든 집의 피자 배달거리를 합한 값.
// M 개의 피자집이 선택되었을 때, 도시의 최소 피자 배달거리는 ?
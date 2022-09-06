package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point3 {
    int x;
    int y;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Section0814 {

    static int n; // 격자판 행렬 길이
    static int m; // 시장이 선택하는 피자집 수
    static int len; // 피자집 갯수
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point3> home = new ArrayList<>();
    static List<Point3> pizza = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];

        // 1. 초기 격자판 Setting
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 가정집
                if (num == 1) {
                    home.add(new Point3(i, j));

                    // 피자집
                } else if (num == 2) {
                    pizza.add(new Point3(i, j));
                }
            }
        }

        len = pizza.size();
        DFS(0, 0);
        System.out.println(answer);
    }

    // 조합 공식 (len 개의 피자집 중 m 개 선택 ->  6개 중 4개 선택 -> len C m)
    private static void DFS(int depth, int startNode) {
        // 하나의 조합이 만들어졌다면 (m 개의 피자집이 선택된 경우) 각 집의 거리와
        if (depth == m) {
            int sum = 0;
            for (Point3 h : home) { // 첫 번째 집의 좌표를 구해온다.
                int distance = Integer.MAX_VALUE; // 도시의 피자배달 거리
                for (int i : combi) { // 모든 집들의 좌표와 살아남은 피자집들의 거리를 비교해 최소 값을 찾는다.
                    distance = Math.min(distance, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += distance;
            }

            // Math.min 을 사용해서 모든 조합의 도시 피자배달 거리를 비교하기 때문에 최초 answer 값은 Integer.MAX_VALUE 로 초기화해야하는 상태이다.
            answer = Math.min(answer, sum);

        } else {
            for (int i = startNode; i < len; i++) {
                combi[depth] = i;
                DFS(depth + 1, i + 1);
            }
        }
    }
}
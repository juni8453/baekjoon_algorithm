package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Brick implements Comparable<Brick> {

    int weigh;
    int high;
    int weight;

    public Brick(int weigh, int high, int weight) {
        this.weigh = weigh;
        this.high = high;
        this.weight = weight;
    }

    // 밑면 기준 내림차순 정렬
    // 가장 넓은 면적의 벽돌을 먼저 쌓아야하므로
    @Override
    public int compareTo(Brick o) {
        return o.weigh - this.weigh;
    }
}

public class Section1004 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[n];

        List<Brick> bricks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weigh = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bricks.add(new Brick(weigh, high, weight));
        }

        // 밑면 기준 내림차순 정렬
        Collections.sort(bricks);

        // LIS 알고리즘 구현
        // 다이나믹 배열의 첫번쨰 원소로 가장 밑면이 좁은 벽돌의 높이로 초기화
        // dy 배열은 쌓은 벽돌의 높이 합의 배열이다.
        dy[0] = bricks.get(0).high;

        for (int i = 1; i < bricks.size(); i++) {
            int maxHigh = 0;
            for (int j = i - 1; j >= 0; j--) {
                // 기준 벽돌 무게보다 비교 벽돌 무게가 더 무거우면 애초에 쌓질 못한다.
                // 현재 쌓을 수 있는 벽돌을 찾고 그 벽돌 배열과 대응되는 dy 배열을 탐색하며 어디에 쌓아야 더 높게 쌓을 수 있는지 찾아낸다.
                // 무게가 3인 벽돌이 있고 4,5 의 무게를 지닌 벽돌이 있다고 가정하자. 무게 4의 벽돌의 탑 높이는 총 3의 높이를 가지고 있고
                // 무게 5의 벽돌의 탑 높이는 총 2의 높이를 가지고 있다고 했을 때, 그 배열에 대응하는 dy 배열을 앞으로 찾아가며
                // 더 높게 쌓여있는 길이를 찾는다. 그리고 그 길이에 자신의 길이를 더해서 탑의 높이 dy[i]를 갱신한다.
                if (bricks.get(i).weight < bricks.get(j).weight && dy[j] > maxHigh) {
                    maxHigh = dy[j];
                }
            }
            dy[i] = maxHigh + bricks.get(i).high;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}

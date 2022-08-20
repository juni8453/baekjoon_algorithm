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
        // 다이나믹 배열의 첫번쨰 원소로 가장 밑면이 좁은 벽돌로 초기화
        dy[0] = bricks.get(0).high;

        for (int i = 1; i < bricks.size(); i++) {
            int maxHigh = 0;
            for (int j = i - 1; j >= 0; j--) {
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

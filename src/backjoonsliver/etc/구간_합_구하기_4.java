package backjoonsliver.etc;

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

public class 구간_합_구하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 구간 합을 구해놓은 배열 n 보다 크기가 하나 더 큰 배열을 하나 만들어준다.
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        // 2. 구간 합의 공식은 sumArr[right] - sumArr[left - 1]
        // 여기서 left = x, right = y
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = points.get(i).x;
            int y = points.get(i).y;
            answers.add(arr[y] - arr[x - 1]);
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}

// 3번째 줄 부터 합을 구해야하는 구간 i 와 j가 주어진다.
// 1 ~ 3
// 2 ~ 4
// 5 ~ 5
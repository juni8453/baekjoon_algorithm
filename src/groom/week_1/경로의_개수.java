package groom.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 1;
        for (int i = 0; i < n; i++) {
            answer *= Long.parseLong(st.nextToken());
        }

        System.out.println(answer);
    }
}

// 3
// 2 3 2
// 1번 섬에서 n 개의 다리를 사용해 다시 1번 섬으로 돌아올 떄의 경우의 수를 구해라.
// i번 섬에서 i + 1 번 섬을 방문할 때, 다른 다리를 이용했다면 다른 경로로 본다.
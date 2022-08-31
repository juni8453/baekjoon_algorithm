package baekjoonbronze.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0; // 현재 인원
        int max = 0; // 최대 값

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int down = Integer.parseInt(st.nextToken());
            int up = Integer.parseInt(st.nextToken());
            sum = sum - down + up;

            if (max < sum) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}

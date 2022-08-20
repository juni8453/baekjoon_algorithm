package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Section1005_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[] dy = new int[m + 1]; // 0 부터 m 인덱스 까지 사용해야한다.
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0; // dy[j] 란, j원을 거슬러주기 위해 필요한 최소 동전 갯수를 의미한다.

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dy.length; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }
        System.out.println(dy[m]);
    }
}

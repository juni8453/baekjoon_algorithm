package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        // dy index = 거슬러주는 값
        // dy index value = 거슬러주기 위한 동전의 최소 개수
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE); // 가장 큰 값으로 초기화해주지 않으면, Math.min() 사용할 수 없으므로 초기화를 꼭 해줘야한다.
        dy[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dy[j] =  Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }

        System.out.println(dy[m]);
    }
}
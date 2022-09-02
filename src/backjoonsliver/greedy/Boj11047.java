package backjoonsliver.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        // 큰 코인부터 검사하는게 빠르니까, 배열 뒤집기
        Collections.reverse(coins);

        // 뒤집은 코인 배열에서 k 보다 작은 숫자면서 제일 큰 코인으로 빼주기
        int count = 0;
        int tmp = 0;

        // 알맞게 큰 코인을 찾았다면 해당 코인을 저장한다.
        for (int coin : coins) {
            if (coin <= k) {
                tmp = coin;
            } else {
                continue;
            }

            // 연산을 수행하면서 k가 tmp 보다 더 커야 뺄 수 있으니까
            // <= 를 해줘야 100 남았을 때 100을 빼주고 하지 아니면 50, 10 으로 넘어간다.
            while(tmp <= k) {
                k -= tmp;
                count ++;
            }
        }

        System.out.println(count);
    }
}

// 동전 0
/* 1 <= N <= 10 / 1 <= K <= 1억
* 동전 총 N 종류, 각각의 동전 무한대로 소유
* 각 동전을 적절히 섞어서 가치의 합을 K 로 만들려고 한다.
* 이때 필요한 동전 갯수의 최소값을 구해라.
* */

// 10(n) 4200(k)
/* 동전의 가치
* 1
* 5
* 10
* 50
* 100
* 500
* 1000
* 5000
* 10000
* 50000
* */
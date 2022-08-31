package baekjoonbronze.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = eucd(a, b);
        System.out.println(result);

        int max = (a / result) * (b / result) * result;
        System.out.println(max);

    }

    // 유클리드 호제법으로 최대공약수 찾기
    static int eucd(int a, int b) {
        if (a > b) {
            int r = a % b;
            if (r == 0) {
                return b;
            } else {
                // 나머지가 0 이상이면 재귀형태로 호출
                return eucd(b, r);
            }
        } else {
            int r = b % a;
            if (r == 0) {
                return a;
            } else {
                return eucd(a, r);
            }
        }
    }
}

// 최대 공약수와 최소 공배수를 출력하는 프로그램 작성
// 최대 공약수는 유클리드 호제법을 사용한다.
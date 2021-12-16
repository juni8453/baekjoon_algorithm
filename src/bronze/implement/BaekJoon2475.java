package bronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sum += temp * temp;
        }
        int result = sum % 10;
        System.out.println(result);
    }
}

// 2475 검증수 문제
// 검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지
// 04256 -> 0 + 16 + 4 + 25 + 38 = 81 % 10 = 1 -> 나머지인 1이 검증수

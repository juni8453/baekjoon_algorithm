package this_is_coding_test.prctice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기_혹은_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long result = str.charAt(0) - '0';

        for (int i = 1; i < str.length(); i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int num = str.charAt(i) - '0';
            if (num <= 1 || result <= 1) { // 1 보다 작거나 같다면 (1 이거나 0 인 경우는 덧셈 연산을 실시하기 위함)
                result += num;
            }
            else {
                result *= num;
            }
        }

        System.out.println(result);
    }
}

/** 그리디 2번 문제 곱하기 혹은 더하기
 * 왼쪽부터 오른쪽으로 하나씩 모드 숫자를 확인하며 숫자 사이에 'x' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구해라.
 * 연산자에 상관없이 모든 연산은 왼쪽 > 오른쪽 순으로 실시한다.
 */

/**
 * 최대한 곱셈 연산을 사용하고 0인 경우에만 덧셈 연산을 사용한다.
 * 0인 경우를 판별하는 분기문만 있으면 풀이 가능할 듯.
 */

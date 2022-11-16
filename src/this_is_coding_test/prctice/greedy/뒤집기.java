package this_is_coding_test.prctice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {

    static int resultCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zeroCount = 0;
        int oneCount = 0;

        fuc(str, zeroCount, oneCount);

        System.out.println(resultCount);
    }

    private static void fuc(String str, int zeroCount, int oneCount) {
        String prev = str.substring(0, 1);

        if (prev.equals("0")) {
            zeroCount++;

        } else {
            oneCount++;
        }

        for (int i = 2; i <= str.length(); i++) {
            String next = str.substring(i - 1, i);

            // perv != next 일 경우 1인지 0인지 판단 후 알맞는 Count++
            if (!prev.equals(next)) {

                // 현재 prev 확인 -> 1인 경우
                if (next.equals("1")) {
                    oneCount++;
                    prev = next;

                    // 현재 prev 확인 -> 0인 경우
                } else {
                    zeroCount++;
                    prev = next;
                }
            }
        }

        resultCount = Math.min(zeroCount, oneCount);
    }
}

// 문자열 str 이 주어졌을 때 연속된 숫자를 선택해 0 -> 1, 1 -> 0 으로 뒤집을 수 있다.
// 모든 숫자를 같게하기 위해 str 을 뒤집을 때, 최소한의 횟수를 구해라.
// "0001100"

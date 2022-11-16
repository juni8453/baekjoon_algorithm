package this_is_coding_test.prctice.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키_스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력은 항상 짝수로 들어오기 때문에 반으로 나눌 수 있다.
        // [1, 2, 3 | 4, 0, 2]
        // 만약 6자리가 입력으로 들어왔다면 자리수 / 2 만큼 반복문 작성해서 비교하면 끝

        // 1. 먼저 int n 을 문자열로 변환
        String str = String.valueOf(n);

        int leftSum = 0;
        for (int i = 0; i < (str.length() / 2); i++) {
            String sub = str.substring(i, i + 1);
            leftSum += Integer.parseInt(sub);
        }

        int rightSum = 0;
        for (int i = (str.length() / 2); i < str.length(); i++) {
            String sub = str.substring(i, i + 1);
            rightSum += Integer.parseInt(sub);
        }

        if (leftSum == rightSum) {
            System.out.println("LUCKY");

        } else {
            System.out.println("READY");
        }
    }
}

/**
 * 특정 조건이란 현재 캐릭터의 점수를 N 이라고 할 때, 점수 N을 자릿수를 기준으로 반으로 나누어
 * 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황을 의미한다.
 * <p>
 * 예를 들어 현재 점수가 123,402라면 왼쪽 부분의 각 자릿수의 합은 1+2+3, 오른쪽 부분의 각 자릿수의 합은 4+0+2이므로
 * 두 합이 6으로 동일하여 럭키 스트레이트를 사용할 수 있다.
 * <p>
 * 럭키 스트레이트를 사용할 수 있다면 "LUCKY"를, 사용할 수 없다면 "READY"라는 단어를 출력한다. 또한 점수 N의 자릿수는 항상 짝수 형태로만 주어진다.
 * 예를 들어 자릿수가 5인 12,345와 같은 수는 입력으로 들어오지 않는다.
 */
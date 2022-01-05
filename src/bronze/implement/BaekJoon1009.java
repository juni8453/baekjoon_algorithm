package bronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int inputCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = 1;

            for (int k = 0; k < b; k++) {
                result *= a;

                if (result >= 10) {
                    result %= 10;
                }

                // result = 10 -> 10이 출력되야하는데 위에서 나눠버렸으므로 다시 10 저장하고 break
                if (result == 0) {
                    result = 10;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}

// 분산처리 문제

// 무식하게 제곱하면 범위가 넘어가서 10이 넘을 때 마다 10으로 나눈 나머지로 값을 바꿔주자.

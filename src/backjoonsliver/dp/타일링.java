package backjoonsliver.dp;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class 타일링 {

    static BigInteger dp[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        dp = new BigInteger[251]; // n <= 250 까지
        dp[0] = new BigInteger("1"); // 이게 왜 1인지 잘 모르겠더..
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for (int i = 3; i <= 250; i++) {
            BigInteger a = dp[i - 1];
            BigInteger b = dp[i - 2];
            BigInteger two = new BigInteger("2");
            dp[i] = a.add(b.multiply(two));
        }

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1; // 2 * 1 의 타일은 2 * 1 타일 하나로 채울 수 있다.
//        dp[2] = 3; // 2 * 2 의 타일은 1 * 2 타일 두 개 + 2 * 2 타일 하나로 채울 수 있다. 2 * 1 타일을 채우는 경우는 n - 1 길이까지에서 고려했기 때문에 제외.
//
//
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + (dp[i - 2] * 2) % 10007;
//        }
//
//        System.out.println(dp[n]);
//    }
//}


// 각각의 n 마다 2 * n 직사각형을 채우는 방법의 수를 출력한다.
// 사용 타일은 2 * 2, 2 * 1, 1 * 2 3개의 타일을 사용할 수 있다.
// n - 1 길이까지 타일이 채워졌다면 2 * 1 타일 하나를 사용해 채울 수 있다.
// n - 2 길이까지 타일이 채워졌다면 2 * 2 타일 하나 or 1 * 2 타일 두 개를 사용해 채울 수 있다.
// 즉, 점화식은 dp[i] = dp[i - 1] + (dp[i - 2] * 2)


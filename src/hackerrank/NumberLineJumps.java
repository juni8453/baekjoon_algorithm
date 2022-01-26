package hackerrank;

import java.io.*;

class Result2 {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        //TODO
        //  출발 위치 x1, x2 는 각 v1, v2 만큼 더해져야한다.
        //  2번 캥거루는 무조건 1번 캥거루 보다 멀리 뛰지 못한다. (멀리 뛰면 절대 못 쫒아감)
        //  1번 캥거루는 무조건 2번 캥거루 보다 뒤에 있다. (앞에 있는데 2번 캥거루보다 더 잘뛰면 절대 못 쫒아감)

        while (true) {
            x1 += v1;
            x2 += v2;

            if (v1 <= v2) {
                return "NO";
            }

            if (x1 == x2) {
                return "YES";
            }

            if (x1 >= x2) {
                return "NO";
            }
        }
    }
}

// 0(a 출발위치) 3(a 점프거리) / 4(b 출발위치) 2(b 점프거리)
// 0 -> 3 -> 6 -> 9 -> 12   (4번 점프)
// 4 -> 6 -> 8 -> 10 -> 12  (4번 점프)
// return YES

// 0 2 5 3
// 0 -> 2 -> 4 -> 6 -> 8 (4번 점프)
// 5 -> 8                (2번 점프)
// return NO

public class NumberLineJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result2.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

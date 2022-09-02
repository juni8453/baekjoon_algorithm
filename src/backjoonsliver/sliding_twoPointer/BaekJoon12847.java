package backjoonsliver.sliding_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] salary = new int[N];

        for (int i = 0; i < salary.length; i++) {
            salary[i] = Integer.parseInt(st2.nextToken());
        }

        long result = solution(N, M, salary);
        System.out.println(result);
    }

    private static long solution(int n, int m, int[] salary) {
        int sum = 0;
        long result = 0;

        for (int i = 0; i < m; i++) {
            sum += salary[i];
        }

        result = sum;

        for (int i = m; i < n; i++) {
            sum += (salary[i] - salary[i - m]);
            result = Math.max(result, sum);
        }

        return result;
    }
}

// 각 날마다 급여가 정해져 있다.
// 취직을 하면 일을 시작한 날부터 끝난 날 까지 하루도 빠질 수 없다.

// N + 1 후에 편의점에 취직하려 한다.
// 최대 M 일 까지 일한다.

// 5(N = 월세를 내기 바로 전날) 3(M = 일을 할 수 있는 날)
// 10 20 30 20 10 (1일 부터 N일 까지 일급)
// 취직한 사람이 일을 해서 벌 수 있는 최대 이익을 출력해라.
package backjoonsliver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] countOfWithdraw = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            countOfWithdraw[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(countOfWithdraw);

        int prevSum = 0;
        int sum = 0;

        // 이전에 걸렸던 시간들의 합을 먼저 셋팅
        // 모든 시간들의 합에 이전시간 더하기
        for (int i = 0; i < n; i++) {
            prevSum +=  countOfWithdraw[i];
            sum += prevSum;
        }

        System.out.println(sum);
    }
}

// 3, 1, 4, 3, 2 (각 번호의 사람마다 인출 시 걸리는 시간) 인 경우 1,2,3,4,5 번으로 줄을 섰다고 가정
// 3 + (3 + 1/4) + (3 + 1 + 4/8) + (3 + 1 + 4 + 3/11) + (3 + 1 + 4 + 3 + 2/13) = 39분

// 3, 1, 4, 3, 2 (인출 시 걸리는 시간) 인 경우 2,5,1,4,3 번으로 줄을 섰다고 가정
// 1 + (1 + 2/3) + (1 + 2 + 3/6) + (1 + 2 + 3 + 3/9) + (1 + 2 + 3 + 3 + 4/ 13) = 32분
// 2, 5, 1, 4, 3 순으로 줄을 서야 모두가 가장 빨리 돈을 뽑을 수 있다.

// 각 사람이 돈을 인출하는데 필요한 시간 합의 최솟값을 출력해라.

/* 상식적으로 접근했을 때, 인출 시 돈을 빨리 뽑을 수 인원부터 앞으로 줄세워기를 해야 최솟값이 나오는 것 같다.
* */

package backjoonsliver.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파닭파닭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] SizeOfGreenOnions = new int[S];
        long sum = 0;

        for (int i = 0; i < S; i++) {
            SizeOfGreenOnions[i] = Integer.parseInt(br.readLine());
            sum += SizeOfGreenOnions[i];
        }

        int left = 1;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < S; i++) {
                count += SizeOfGreenOnions[i] / mid;
            }

            if (count >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 최적의 파 길이 * 만들어야하는 닭의 갯수 = 사용되는 전체 파 길이
        // 입력된 전체 파 길이 - 사용되는 전체 파 길이 = 남는 파 길이 (라면에 넣을 수 있는 양)
        System.out.println(sum - right * (long) C);

    }
}

/* 최대 파의 길이를 구하는 방법은 ?
 * 이분탐색 알고리즘을 사용해서 mid = (left + right) / 2 변수를 설정
 * 그리고 배열의 파 길이와 mid 를 각각 나눠서 해당 mid 값으로 몇 개의 파닭을 만들 수 있는지 구한다.
 * 만약 만들어야하는 파닭 갯수보다 결과값이 작다면 mid (잘라낸 파 길이) 길이가 큰거니까 right = mid - 1
 * 반대로 만들어야하는 파닭 갯수보다 결과값이 크다면 mid 길이가 적정 값보다 작은거니까 left = mid + 1
 * 만들어야하는 파닭 갯수와 결과값이 동일하더라도 left <= right 가 될 때까지가 적정 값이기 때문에 같아질때까지 left = mid + 1
 * */

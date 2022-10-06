package backjoonsliver.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());  // 이미 가지고 있는 랜선의 갯수
        int n = Integer.parseInt(st.nextToken());  // K 를 잘라서 만들어내야하는 랜선의 갯수

        int[] line = new int[k];
        for (int i = 0; i < line.length; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        // 이분탐색을 위해 정렬
        Arrays.sort(line);

        long start = 1;
        long end = line[k - 1];
        long mid = (start + end) / 2;

        while (start <= end) {
            int count = 0;

            // 임의의 mid 값을 각 랜선의 길이와 나눠서 몇 개의 랜선을 만들 수 있는지 구한다.
            for (int i = 0; i < k; i++) {
                count += line[i] / mid;
            }

            // 너무 짧게 나왔을 때
            if (count >= n) {
                start = mid + 1;
                mid = (start + end) / 2;

                // 너무 길게 나왔을 때
            } else
                end = mid - 1;
                mid = (start + end) / 2;
        }

        System.out.println(mid);
    }
}

// 1 <= K <= 10,000
// 1 <= N <= 1,000,000
// 항상 K <= N
// 모두 N 개와 같은 길이의 랜선으로 만들고 싶어하고 K 개의 랜선을 잘라서 만들어야한다.
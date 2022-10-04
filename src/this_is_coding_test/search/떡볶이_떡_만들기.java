package this_is_coding_test.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int start = 0;
        int end = arr[n - 1];
        int mid = (start + end) / 2;

        // mid 로 모든 떡을 자른 합이 target 이 된다.
        while (start <= end) {
            int target = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    target += (arr[i] - mid);
                }
            }

            // 너무 길쭉하게 잘랐음.
            if (target > m) {
                start = mid + 1;
                mid = (start + end) / 2;

            // 너무 짧게 잘랐음.
            } else if (target < m) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                answer = mid;
                break;
            }
        }

        System.out.println(answer);
    }
}

// 파라메트릭 서치 문제
// 절단기의 적절한 높이를 찾을 때(조건을 만족할 때) 까지 높이를 수정.
// 4 6
// 10 15 17 19 return 15

package this_is_coding_test.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기_Remind {
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
        int end = 1_000_000_000;

        while (start <= end) {
            int target = 0; // 임의의 절단기 높이 mid 로 잘린 떡 길이의 합
            int mid = (start + end) / 2;

                for (int i = 0; i < n; i++) {
                    if (arr[i] > mid) { // 떡 높이가 절단기 높이보다 낮아야 잘리니까
                    target += (arr[i] - mid);
                }
            }

            // 절단기 높이가 너무 낮음
            if (target == m) {
                answer = mid;
                break;

            } else if (target < m) {
                end = mid - 1;

            // 절단기 높이가 너무 높음
            } else  {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

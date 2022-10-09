package this_is_coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 위에서_아래로_Remind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 삽입 정렬
        // [1] index 부터 시작하고, 내부 반복문은 1씩 감소하는 형태로 구현한다.
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int prev = i - 1;

            // 현재 선택된 원소가 이전 원소보다 큰 경우까지 반복 (내림차순)
            while (prev >= 0 && arr[prev] < tmp) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // 탐색 종료된 지점에 현재 선택된 변수의 값을 삽입
            arr[prev + 1] = tmp;
        }

        // 1. 선택 정렬
        // 선택 정렬은 배열을 차례로 탐색하면서 기준 원소와 배열 중 가장 작은 수를 찾아 서로 바꾸는 식으로 구현한다.
        // 내림차순은 반대로 .
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // 인덱스 기억

            // 배열에서 가장 큰 값을 지닌 인덱스 찾기
            for (int j = i + 1; j < n; j++) {
                // 더 큰 값이라면 ?
                if (arr[j] > arr[minIdx]) {
                    minIdx = j; // 해당 인덱스 기억
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}

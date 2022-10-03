package this_is_coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 위에서_아래로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 선택 정렬
        for (int i = 0; i < n - 1; i++) {
            int idx = i;

            // 최대값을 가진 인덱스 찾기
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[idx]) {
                    idx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 2. 삽입 정렬
        for (int i = 1; i < n; i++) {
            int j = 0;
            int target = arr[i];

            for (j = i - 1; j >= 0; j--) {
                if (target > arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = target;
        }

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

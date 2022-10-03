package this_is_coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두_배열의_원소_교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        Integer[] arrB = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        // K 만큼 arrA, arrB 를 차례로 비교하면서 arrA[i] < arrB[i] 일 떄는 sum += arrB[i] / 반대일 떄는 반대로 더해준다.
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (arrA[i] < arrB[i]) {
                int tmp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = tmp;
            } else {
                break;
            }
        }

        for (int i : arrA) {
            sum += i;
        }

        System.out.println(sum);
    }
}

// 배열 A 의 최솟값과 배열 B 의 최대값을 서로 바꿔준 뒤 배열 A 의 모든 원소를 더해 반환한다.
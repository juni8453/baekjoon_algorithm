package this_is_coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두_배열의_원소_교체_Remind {
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

        // A 배열은 오름차순, B 배열은 내림차순으로 정렬한다.
        // A = [1,2,3,4,5], B = [6,6,5,5,5]
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        // K 만큼 반복하면서 i번째 원소를 서로 교환한다.
        for (int i = 0; i < k; i++) {
            if (arrA[i] < arrB[i]) {
                int tmp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = tmp;
            }
        }

        int sum = 0;
        for (int i : arrA) {
            sum += i;
        }

        System.out.println(sum);
    }
}

// A = [1,2,5,4,3]
// B = [5,5,6,6,5]

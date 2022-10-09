package this_is_coding_test.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기_Remind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] store = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] customer = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            customer[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 이진 탐색 전 각 배열을 정렬한다.
        Arrays.sort(store); // [2, 3, 7, 8, 9]
        Arrays.sort(customer); // [5, 7, 9]

        // 2. customer 배열에서 원소 하나를 저장, store 배열에서 있는지 없는지 탐색한다.
        for (int i = 0; i < customer.length; i++) {
            boolean check = binarySearch(customer, store, n, i);

            if (check) {
                System.out.print("yes" + " ");
            } else {
                System.out.print("no" + " ");
            }
        }

    }

    private static boolean binarySearch(int[] customer, int[] store, int n, int i) {
        int target = customer[i];
        int start = 0;
        int end = store.length;

        while (start <= end) {
            // 목표값이 더 크면 목표값 왼쪽으로는 탐색할 필요가 없으므로 start = mid + 1
            int mid = (start + end) / 2;
            if (target > store[mid]) {
                start = mid + 1;

            } else if (target < store[mid]) {
                end = mid - 1;

            } else if (target == store[mid]){
                return true;
            }
        }
        return false;
    }
}

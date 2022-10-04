package this_is_coding_test.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 부품찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] partsOfStore = new int[n];
        for (int i = 0; i < n; i++) {
            partsOfStore[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] requestParts = new int[m];
        for (int i = 0; i < m; i++) {
            requestParts[i] = Integer.parseInt(st.nextToken());
        }

        // 이진탐색은 정렬된 데이터에서만 사용이 가능하다.
        Arrays.sort(partsOfStore);

        List<String> answers = new ArrayList<>();

        for (int i = 0; i < requestParts.length; i++) {
            if (binarySearch(requestParts, partsOfStore, n, i)) {
                answers.add("yes");
            } else {
                answers.add("no");
            }
        }

        for (String answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private static boolean binarySearch(int[] requestParts, int[] partsOfStore, int n, int i) {
            int target = requestParts[i];
            int start = 0;
            int end = n - 1;
            int mid = (start + end) / 2;

            while (start <= end) {
                // 목표값이 중간값보다 크다면 목표값 왼쪽으로는 탐색할 필요가 없으므로 시작점을 중간값 인덱스 +1 쪽으로 옮긴다.
                if (target > partsOfStore[mid]) {
                    start = mid + 1;
                    mid = (start + end) / 2;

                } else if(target < partsOfStore[mid]) {
                    end = mid - 1;
                    mid = (start + end) / 2;

                } else if (target == partsOfStore[mid]) {
                    return true;
                }

            }

        return false;
    }
}

// 손님이 요청한 부품 번호의 순서대로 부품을 확인해야한다.
// [8, 3, 7, 9, 2] - 매장 내 부품
// [5, 7, 9] - 손님이 요구하는 부품
// return -> no, yes, yes
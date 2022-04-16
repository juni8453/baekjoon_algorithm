package study.section3;

import java.util.Scanner;

public class Section0303 {
    public static void main(String[] args) {
        // n = n 일
        // k = 연속된 k 일
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[2];

        arr[0] = sc.nextInt();
        int n = arr[0];

        arr[1] = sc.nextInt();
        int k = arr[1];

        int[] nArray = new int[n];

        for (int i = 0; i < nArray.length; i++) {
            nArray[i] = sc.nextInt();
        }

        int result = solution(n, k, nArray);
        System.out.println(result);
    }

    private static int solution(int n, int k, int[] arr) {
        int result = 0;
        int sum = 0;

        if (n == k) {
            for (int i : arr) {
                result += i;
                return result;
            }
        }

        // 창문을 하나 만들자
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        result = sum;

        // 창문을 한 칸씩 밀고 나간다.
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]);
            result = Math.max(result, sum);
        }

        return result;

        // 12 15 11 20 25 10 20 19 13 15 [n = 10]
        // 11 + 20 + 25 = 56 [k = 3]

        // 12 + 15 + 11 = 38
        // 38 + 20 - 12 = 46
        // 46 + 25 - 15 = 56
        // ... 이런 식으로 진행

    }
}
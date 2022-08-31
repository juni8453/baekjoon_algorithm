package baekjoonbronze.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2581 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        getPrice();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) { // 소수일 때,
                sum += arr[i];

                if (min > arr[i]) {
                    min = arr[i];
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    private static void getPrice() {
        // 배열 초기화
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        // 소수 판별
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) { // 이미 지워진 배수는 Pass
                continue;
            }

            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }
    }
}

// m <= i <= n 이하의 자연수 중 소수인 것을 모두 골라 소수의 합과 소수의 최소값을 출력해라.

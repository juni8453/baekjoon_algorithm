package baekjoonbronze.basic;

import java.io.IOException;

public class SieveOfEratosthenes {
    static int number;
    static int[] arr;

    public static void main(String args[]) throws IOException{
        number = 100;
        arr = new int[number + 1];
        primeNumber();
    }

    private static void primeNumber() {
        // 1. 배열 초기화
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        // 2. 2부터 시작해서 배수 지우기
        for (int i = 2; i <= number; i++) {
            if (arr[i] == 0) { // 2-1. 이미 지운 배수는 건너뛰기
                continue;
            }

            // 2-2. 자기 자신을 제외한 i의 배수 지우기 (2의 배수, 3의 배수 ...)
            for (int j = i + i; j <= number; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = 2; i <= number; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}

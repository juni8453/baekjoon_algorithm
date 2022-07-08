package study.section3;

import java.util.Scanner;

public class Section0306 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = solution(n, k, arr);
        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int count = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                count++;
            }

            while (count > k) {
                if (arr[lt] == 0) {
                    count--;
                }

                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
}

/* 최대 길이 연속부분수열
* input = 14, 2
* input = 1 1 0 0 1 1 0 1 1 0 1 1 0 1
* 2개의 0을 1로 바꿀 수 있고, 현재 바꿨을 때 연속된 1이 가장 많은 길이는 8개
* 즉, output = 8
* */
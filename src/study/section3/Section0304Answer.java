package study.section3;

import java.util.Scanner;

public class Section0304Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = solution(arr, m);
        System.out.println(answer);
    }

    private static int solution(int[] arr, int m) {
        int sum = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        // TODO left, right Pointer 필요
        //  위 문제와 다르게 한 줄 배열에서는 투포인터, 슬라이딩을 섞어써야하는 듯

        // 탈출 조건식은 배열 크기까지만 돌도록 설정
        while (right < arr.length) {
            sum += arr[right];
            right++;
            if (sum == m) {
                count ++;
                right ++;
            }

            while (sum > m) {
                sum -= arr[left++];
                if (sum == m) {
                    count ++;
                }
            }
        }

        return count;
    }
}

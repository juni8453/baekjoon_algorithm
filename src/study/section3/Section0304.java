package study.section3;

import java.util.Scanner;

public class Section0304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 배열의 길이
        int m = sc.nextInt();   // 연속부분수열의 합

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Section0304.solution(arr, n, m);
        System.out.println(answer);

    }

    private static int solution(int[] arr, int n, int m) {
        int sum = 0;
        int count = 0;
        int left = 0;

        // lt ~ rt 까지의 합이 m 과 같아야 count ++
        // 구간 합이 m 보다 작아질 때 까지 lt 빼주기.
        // m 보다 작아졌으니까 다시 rt 증가시키면서 구간 합이 m 과 같아질 때 count++

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            if (sum == m) {
                count ++;
            }

            while (sum >= m) {
                sum -= arr[left++];
                if (sum == m) {
                    count++;
                }
            }
        }

        return count;
    }
}

/*
* N 개의 수로 이루어진 수열이 존재
* 해당 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번인지 구해라.
* */


/*
* Input Value
* 8 6
* 1 2 1 3 1 1 1 2
*
* Output Value
* 3
* */

// 최초 arr[0] 부터 하나 씩 더해가면서 sum 으로 만들고 m 과 비교한다.
// sum 값이 m 값보다 작다면, 뒤에 인덱스 값을 하나 더 더한다. (반복)
// sum 과 m 을 비교하다가,
// sum == m 이라면 count ++ 한다.
// sum > m 이라면
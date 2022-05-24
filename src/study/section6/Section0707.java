package study.section6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Section0707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override

            // o2 기준행, o1 기준행의 다음행
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

/* 7-7 좌표정렬
* 좌표 x,y 가 주어지면, 모든 좌표를 오름차순으로 정렬해라.
* x 값이 먼저, 만약 x 값이 같다면 y 값에 의해 정렬
* */

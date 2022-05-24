package study.section6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PositionSortingMy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 여기서 int[] 는 2차원 배열에서 하나의 행을 기준으로 비교한다는 의미 (행 단위로 비교)
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override

            // o1 은 최초 1번째 행, o2 는 0번째 행을 의미 (o2 는 기준이 되는 행, o1 은 그 다음 행을 의미한다)
            public int compare(int[] o1, int[] o2) {

                // Integer.compare(x, y) 은 x - y
                // 즉, 음수가 나오면 x > y
                // 같다면 x == y
                // 양수가 나오면 x < y
                // 다음 행의 x 값과 기준 행의 x 값이 같다면 y 좌표를 기준으로 비교한다.
                // [0] 은 행의 x 값, [1] 은 행의 y 값
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[1]);
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

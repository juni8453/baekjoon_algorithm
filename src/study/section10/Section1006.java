package study.section10;

import java.io.IOException;
import java.util.Scanner;

public class Section1006 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제 갯수
        int m = sc.nextInt(); // 총 제한시간
        int[] dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);
            }
        }

        System.out.println(dy[m]);
    }
}

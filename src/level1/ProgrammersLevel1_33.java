package level1;

import java.util.Scanner;

public class ProgrammersLevel1_33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aCount = sc.nextInt();
        int bCount = sc.nextInt();

        int[] a = new int[aCount];
        int[] b = new int[bCount];

        for (int i = 0; i < aCount; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < bCount; i++) {
            b[i] = sc.nextInt();
        }

        int answer = solution(a, b);
        System.out.println(answer);
    }

    private static int solution(int[] a, int[] b) {
        int answer = 1234567890;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}

// a[n-1]*b[n-1]

// a와 b를 내적하는 answer 값을 return 하는 메소드를 구현해라.
// ex) a = [1,2,3,4], b = [-3,-1,0,2]
// (1 * -3) + (2 * -1) + (3 * 0) + (4 * 2) = -3 + -2 + 0 + 8 = 3
// 즉 return 값은 3

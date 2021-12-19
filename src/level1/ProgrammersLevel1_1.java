package level1;

import java.util.Scanner;

public class ProgrammersLevel1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        solution(x, n);

    }

    public static void solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i+1);
            System.out.print(answer[i] + " ");
        }
    }
}


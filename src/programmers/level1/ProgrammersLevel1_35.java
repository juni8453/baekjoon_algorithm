package level1;

import java.util.Scanner;

public class ProgrammersLevel1_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aCount = sc.nextInt();
        int bCount = sc.nextInt();

        int[] absolutes = new int[aCount];
        boolean[] signs = new boolean[bCount];

        for (int i = 0; i < absolutes.length; i++) {
            absolutes[i] = sc.nextInt();
        }

        for (int i = 0; i < signs.length; i++) {
            signs[i] = sc.nextBoolean();
        }

        int answer = solution(absolutes, signs);
        System.out.println(answer);

    }

    private static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                absolutes[i] = Math.abs(absolutes[i]);
            }

            else {
                absolutes[i] *= -1;
            }

            answer += absolutes[i];
        }

        return answer;
    }
}


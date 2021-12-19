package level1;

import java.util.Scanner;

public class ProgrammersLevel1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        boolean answer = solution(x);
        // x가 하샤드 수라면 true, 아니라면 false 출력
        System.out.println(answer);
    }

    private static boolean solution(int x) {
        boolean answer = true;
        int cloneX = x;
        int sum = 0;
        int temp = 0;

        // 각 자리수 더하기
        while (x != 0) {
            temp = x % 10;
            sum += temp;
            x /= 10;
        }

        if (cloneX % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}

package programmers.level1;

import java.util.Scanner;
import java.lang.Math;

public class ProgrammersLevel1_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long answer = solution(n);
        System.out.println(answer);
    }

    private static long solution(long n) {
        long answer = (long) Math.sqrt(n);

        if (n == Math.pow(answer, 2)) { // Math.pow (거듭제곱 하고 싶은 수, 몇 번)
            return (long) Math.pow(answer + 1, 2);
        }

        else {
            return -1;
        }
    }
}

// 임의의 양의 정수 n에 대해, 어떤 양의 정수 x의 제곱인지 아닌지 판단한다.
// n이 양의 정수 x의 제곱이면 x + 1의 제곱을 return
// n이 양의 정수 x의 제곱이 아니라면 -1을 return

// n = 121 -> return = 144
// n = 3 -> return = -1

package leetcode;

import java.util.*;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int answer = soulution(x);
        System.out.println(answer);
    }

    private static int soulution(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        long reverse = 0;

        while(x != 0) {
            // 숫자를 더하는 거라서 자리 수를 더해주고 더하기 위해 10을 곱해준다.
            reverse *= 10;
            reverse += x % 10;
            x /= 10;
        }

        if (min > reverse || max < reverse) {
            return 0;
        }

        return (int) reverse;
    }
}

// x = 123 -> return 321

// x = -123 -> return -321

// x = 120 -> 21

// -2^31 , 2^31 - 1 범위 (int 범위)를 벗어냐면 0 return

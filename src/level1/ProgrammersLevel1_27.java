package level1;

import java.util.Scanner;

public class ProgrammersLevel1_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
        int x = 1;

        while (n % x != 1) {
            x++;
        }

        return x;
    }
}


// 자연수 n이 매개변수로 주어지고, n을 x로 나눈 나머지가 1이 되도록
// 가장 작은 자연수 x를 return 하는 함수 solution 을 구현하시오.

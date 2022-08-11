package level1;

import java.util.Scanner;

public class ProgrammersLevel1_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = solution(n);
        System.out.println(answer);

    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}

// 정수 n을 받아 n의 약수를 모두 더한 값을 리턴하는 함수를 만들어라
// n = 12 -> return = 28
// n = 5 -> return = 6

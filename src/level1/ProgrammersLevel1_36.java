package level1;

import java.util.Scanner;

public class ProgrammersLevel1_36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();

        int answer = solution(left, right);
        System.out.println(answer);
    }

    private static int solution(int left, int right) {
        int answer = 0;
        int count = 0;

        while (left != right + 1) {

            for (int i = 1; i <= left; i++) {
                if (left % i == 0) {
                    count++;
                }
            }

            if (count % 2 == 0) {
                answer += left;
            }

            else {
                answer -= left;
            }

            left++;
            count = 0;
        }

        return answer;
    }
}


// left ~ right 까지 모든 수들 중 약수의 개수가 짝수인 수는 더하고,
// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 메소드를 구현해라.

// ex) left = 13, right = 17
/*
* 13 -> 1,13 2개
* 14 -> 1,2,7,14 4개
* 15 -> 1,3,5,15 4개
* 16 -> 1,2,3,8,16 5개
* 17 -> 1,17 2개
* 13 + 14 + 15 - 16 + 17 = 43 을 return
* */

package level1;

import java.util.Scanner;

public class ProhrammersLevel1_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long answer = solution(a, b);

        System.out.println(answer);
    }

    public static long solution(int a, int b) {
        long answer = 0;

        if (a < b) {
            for (int i = a; i < b + 1; i++) {
                answer += i;
            }
        }

        else {
            for (int i = b; i < a + 1; i++) {
                answer += i;
            }
        }

        return answer;
    }
}

// a = 3, b = 5 return = 3 + 4 + 5 = 12
// a = 3, b = 7 return = 3 + 4 + 5 + 6 + 7 = 25
// a,b 가 같은 경우 둘 중 아무 수나 return

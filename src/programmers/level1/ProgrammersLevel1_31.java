package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProgrammersLevel1_31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
        // 몫
        int quotient = n;

        // 나머지
        List<Integer> remainder = new ArrayList<>();

        while (quotient != 0) {
            remainder.add(quotient % 3);
            quotient /= 3;
        }

        // 만들어진 3진법 리스트
        Collections.reverse(remainder);

        // 앞뒤 반전해야 해서 다시 뒤집기
        Collections.reverse(remainder);

        String remainders = "";
        for (int i = 0; i < remainder.size(); i++) {
            remainders += String.valueOf(remainder.get(i));
        }

        // String 타입 문자열을 radix = 3 즉, int 형 3진수로 변환
        return Integer.parseInt(remainders, 3);
    }
}

// 3진법 뒤집기
// 매개변수 n 을 3진법 상에서 앞뒤로 뒤집고 이를 다시 10진법으로 표현한 수를 return 하는 메소드 solution 을 구현하라.
// ex) n = 45 -> result = 7
// n = 45 (10진법) -> n = 1200 (3진법) -> 0021 (3진법 앞뒤반전) -> return = 7 (0021을 10진법으로 표현)


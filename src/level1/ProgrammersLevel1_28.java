package level1;

import java.util.Scanner;

public class ProgrammersLevel1_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int money = sc.nextInt();
        int count = sc.nextInt();

        long answer = solution(price, money, count);

        System.out.println(answer);
    }

    private static long solution(int price, int money, int count) {
        long answer = -1;
        long resultPrice = price;

        for (int i = 1; i <= count; i++) {
            resultPrice += ((long) price * i);
        }

        resultPrice -= price;

        if (resultPrice > money) {
            answer = resultPrice - money;
        }

        else if (resultPrice <= money) {
            answer = 0;
        }

        return answer;
    }
}

// 기구 최초 이용료 price
// n번째 이용한다면 원래 (price * n) 원
// ex) 처음 이용료 = 100 -> 2번째 이용료 (100 * 2) -> 3번째 이용료 (100 * 3)
// 기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지 return 하는 함수를 구현해라.
// 단, 금액이 부족하지 않다면 0을 return


// price = 3, monet = 20, count = 4, result = 10
// 이용료가 3인 놀이기구를 4번 타기 위해선 (3 * 1) + (3 * 2) + (3 * 3) + (3 * 4) = 30원 필요
// 현재 가진 돈이 20이기 때문에 10을 return

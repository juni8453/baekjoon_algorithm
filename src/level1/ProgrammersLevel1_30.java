package level1;

import java.util.*;

public class ProgrammersLevel1_30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int budget = sc.nextInt();

        int[] d = new int[n];

        for (int i = 0; i < d.length; i++) {
            d[i] = sc.nextInt();
        }

        int answer = solution(d, budget);
        System.out.println(answer);
    }

    private static int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            result += d[i];

            if (result > budget) {
                answer = i;
                break;
            }

            if (result <= budget) {
                answer = d.length;
            }
        }

        return answer;
    }
}


// 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼 모두 지원해줘야 한다.
// 1000원을 지원한 부서는 정확히 1000원을 지원해야 하고, 1000원 보다 적은 금액을 지원할 수는 없다.
// d = 부서별로 신청한 금액, budget = 전체 예산
// 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하는 함수 solution 을 구현하시오.

// ex) 부서 별 신청 금액 d = [1,3,2,5,4], 예산 = 9, 최대 3개의 부서에 지원해줄 수 있으므로 return = 3

package baekjoonbronze.implement;

import java.util.Scanner;

public class BaekJoon1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k = sc.nextInt();
        int buyBottle = 0;

        // 2의 제곱인지 확인
        int checkN = (int)Math.pow(n, 3);
    }
}

// k는 n의 값을 넘을 수 없음

// n = 1 (2^0), k = 1 (ok)
// n = 2 (2^1), k = 1, 2 (ok)
// n = 4 (2^2), k = 1, 2, 3, 4 (ok)
// n = 8 (2^3), k = 1, 2, 3, 4, 5, 6, 7, 8 (ok)
// 2의 제곱만큼 물병이 있으면 상점에서 물병을 따로 사지 않아도 n 값을 넘지 않는 선에서 k 모두 해결 가능

// 2의 제곱이 아닌 n이 주어졌을 때 물병을 얼만큼 사는가 ? (n이 2의 제곱이 될만큼 산다)
// n = 3 -> buy = 1 -> (3 + 1) = 4 -> 2^2
// n = 13 -> buy = 3 -> (13 + 3) = 16 -> 2^4
// 테스트 케이스 3번에서 막혔는데 다시 생각해봐야겠음 ;;

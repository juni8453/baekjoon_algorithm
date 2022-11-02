package groom.week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 체크카드 {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 잔액
        int m = Integer.parseInt(st.nextToken()); // 거래 횟수
        int currentBalance = n; // 세 가지 작업에 의한 유동 잔액

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            // 입금 시 대기열에 거래가 남아있고 해당 거래를 처리할 수 있는 만큼 처리한다.
            if (type.equals("deposit")) {
                currentBalance += k;

                while (!queue.isEmpty() && queue.peek() <= currentBalance) {
                    int wait = queue.peek();
                    currentBalance -= wait;
                    queue.poll();
                }

            } else if (type.equals("pay")) {
                if (currentBalance >= k) {
                    currentBalance -= k;
                }

            } else {
                if (!queue.isEmpty()) {
                    queue.offer(k);

                } else if (queue.isEmpty() && currentBalance >= k) {
                    currentBalance -= k;

                } else {
                    queue.offer(k);
                }
            }
        }

        System.out.println(currentBalance);
    }
}

/**
 * 1. deposit - 주어진 금액 k 만큼 계좌에 돈이 입금된다.
 *
 * 2. reservation - 주어진 금액 k 만큼 계좌에서 돈이 출금된다.
 *   단, 잔액 < k 거나 대기 목록의 다른 결제가 대기 중이라면 결제 되지 않고 대기 목록의 맨 뒤에 추가한다.
 *
 * 3. pay - 그어진 금액 k 만큼 계좌에서 돈이 출금된다.
 *   단, 계좌의 잔액 < k 라면 결제되지 않는다.
 */

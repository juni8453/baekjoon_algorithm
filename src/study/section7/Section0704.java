package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section0704 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        for (int i = 1; i <= length; i++) {
            int result = DFS(i);
            System.out.print(result + " ");
        }
    }

    public static int DFS(int index) {
        // 가장 아래 노드 두 개는 1로 초기화 되어있어야 하므로 초기 설정 추가.
        if (index == 1 || index == 2) {
            return 1;
        } else {
            return DFS(index - 2) + DFS(index - 1);
        }
    }
}

// 재귀를 이용해 피보나치 수열을 출력해라.
// 피보나치 수열이란 앞에 두 개의 수를 더해 다음 숫자가 되는 수열이다.
// 1 1 2 3 5 8 13 ...
// 1,2 번 인덱스는 1,1 고정이다.
